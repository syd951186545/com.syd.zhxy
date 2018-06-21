package com.syd.zhxy.Views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView.ScaleType;

public class CircleView extends View {

    private Paint paint = null;
    private PaintFlagsDrawFilter pfdf = null;
    // 在已有的图像上绘图将会在其上面添加一层新的形状, 设置这两个形状的显示方式
    private PorterDuffXfermode xfermode = null;
    private RectF rectf = null;
    private Bitmap bitmap = null;
    private Bitmap destBmp = null;
    private Matrix matrix = null;
    private ScaleType scaleType = ScaleType.CENTER_CROP;

    public CircleView(Context context) {
        super(context);
        init(context, null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    // public CircleView(Context context, AttributeSet attrs, int defStyleAttr,
    // int defStyleRes) {
    // super(context, attrs, defStyleAttr, defStyleRes);
    // init(context, attrs);
    // }

    private void init(Context context, AttributeSet attrs) {
        try {
            if (android.os.Build.VERSION.SDK_INT >= 11) {
                setLayerType(LAYER_TYPE_SOFTWARE, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        // 透明度: 00%=FF（不透明） 100%=00（透明）
        // paint.setColor(Color.parseColor("#ffffffff"));
        // 解决图片拉伸后出现锯齿的两种办法: 1.画笔上设置抗锯齿 2.画布上设置抗锯齿
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setAntiAlias(true);
        int clearBits = 0;
        int setBits = Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG;
        pfdf = new PaintFlagsDrawFilter(clearBits, setBits);
        // PorterDuff.Mode.MULTIPLY只显示重叠部分
        xfermode = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
        matrix = new Matrix();
    }

    public void setImageResource(int resId) {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), resId);
        setBitmap(bmp);
    }

    public void setBitmap(Bitmap bmp) {
        this.bitmap = bmp;

    }

    public void setScaleType(ScaleType scaleType) {
        this.scaleType = scaleType;
    }

    private void makeDestBmp(int width, int height) {
        destBmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        rectf = new RectF(0, 0, width, height);
        Canvas canvas = new Canvas(destBmp);
        canvas.drawOval(rectf, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (bitmap == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int bmpWidth = bitmap.getWidth();
        int bmpHeight = bitmap.getHeight();
        if (destBmp == null) {
            makeDestBmp(width, height);
        }
        // canvas.save();
        // 设置画布抗锯齿
        canvas.setDrawFilter(pfdf);
        canvas.drawBitmap(destBmp, 0, 0, paint);
        paint.setXfermode(xfermode);
        switch(scaleType) {
            case FIT_XY:
                canvas.drawBitmap(bitmap, null, rectf, paint);
                break;
            case CENTER_CROP:
            default:
                matrix.reset();
                float scale = Math.max((float) width / (float) bmpWidth, (float) height / (float) bmpHeight);
                // 默认绕原点进行缩放 matrix.postScale(scale, scale, 0, 0);
                matrix.postScale(scale, scale, 0, 0);
                matrix.postTranslate((width - bmpWidth * scale) / 2f, (height - bmpHeight * scale) / 2f);
                canvas.drawBitmap(bitmap, matrix, paint);
                break;
        }
        paint.setXfermode(null);
        // canvas.restore();
    }
}