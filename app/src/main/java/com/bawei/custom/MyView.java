package com.bawei.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/*
 *@Auther:cln
 *@Date: 2019/5/21
 *@Description:功能
 * */
public class MyView extends View {

    private Paint paint, paint1, paint2;
    private int width;
    private int height;
    private float x;
    private float y;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth();
        height = getHeight();
        //画笔
        paint = new Paint();
        //字体大小
        paint.setTextSize(30);
        //画笔颜色
        paint.setColor(Color.RED);
        //画笔宽度
        paint.setStrokeWidth(5);
        //画笔
        paint1 = new Paint();
        //字体大小
        paint1.setTextSize(30);
        //画笔颜色
        paint1.setColor(Color.YELLOW);
        //画笔宽度
        paint1.setStrokeWidth(10);
        //画笔
        paint2 = new Paint();
        //字体大小
        paint2.setTextSize(50);
        //画笔颜色
        paint2.setColor(Color.BLACK);
        //画笔宽度
        paint2.setStrokeWidth(5);
        //画线
        //canvas.drawLine(40, 40, 200, 40,paint);
        //canvas.drawLine(100, 200, 300, 200, paint1);
        //圆角矩形
        canvas.drawRoundRect(5f, 5f, width - 2f, height - 5f, 5f, 2f, paint);
        //圆形
        canvas.drawCircle(width / 2, height / 4, 100, paint1);
        //弧形
        RectF rectF = new RectF(5f, -400f, width - 5f, 300f);
        canvas.drawArc(rectF, 0, 180, false, paint1);
        //文字
        canvas.drawText("开", width / 2 - 20, height / 4 + 15, paint2);
        //矩形
        canvas.drawRect(100f, 700f, 600, 900, paint1);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        Log.i("MyView", "onTouchEvent: " + "X轴:" + x + "Y轴:" + y);

        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                if ((x >= 100 && x <= 600) && (y >= 700 && y <= 900)) {
                    //Toast.makeText(getContext(), "按下", Toast.LENGTH_SHORT).show();
                    Log.i("MyView", "onTouchEvent: " + "按下");

                }
                break;
            case MotionEvent.ACTION_UP:
                if ((x >= 100 && x <=600) && (y >= 700 && y <= 900)) {
                    //Toast.makeText(getContext(), "抬起", Toast.LENGTH_SHORT).show();
                    Log.i("MyView", "onTouchEvent: " + "抬起");
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if ((x >= 100 && x <=600) && (y >= 700 && y <= 900)) {
                    //Toast.makeText(getContext(), "抬起", Toast.LENGTH_SHORT).show();
                    Log.i("MyView", "onTouchEvent: " + "移动");
                }
                break;
        }
        return true;
        //return super.onTouchEvent(event);
    }
}
