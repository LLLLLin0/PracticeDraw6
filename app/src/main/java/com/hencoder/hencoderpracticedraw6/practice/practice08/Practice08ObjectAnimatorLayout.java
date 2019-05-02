package com.hencoder.hencoderpracticedraw6.practice.practice08;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice08ObjectAnimatorLayout extends RelativeLayout {
    Practice08ObjectAnimatorView view;
    Button animateBt;

    public Practice08ObjectAnimatorLayout(Context context) {
        super(context);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = (Practice08ObjectAnimatorView) findViewById(R.id.objectAnimatorView);
        animateBt = (Button) findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，用 ObjectAnimator 播放动画
                // 1. 用 ObjectAnimator 创建 Animator 对象
                // 2. 用 start() 执行动画
                // *. 记得在 Practice08ObjectAnimatorView 中为 progress 添加 setter/ getter 方法！
//                ObjectAnimator animator = ObjectAnimator.ofFloat(view, "progress", 0, 100);
//                animator.setDuration(300).start();

                Keyframe k0 = Keyframe.ofFloat(0, 0);
                Keyframe k1 = Keyframe.ofFloat(0.5f, 100);
                Keyframe k2 = Keyframe.ofFloat(1, 0);
                PropertyValuesHolder progress = PropertyValuesHolder.ofKeyframe("progress", k0, k1, k2);
                ObjectAnimator.ofPropertyValuesHolder(view, progress).setDuration(5000).start();
            }
        });
    }
}
