/*
 * Copyright (c) 2017 Dewin J. Martínez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *             http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dewinjm.textclock;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.TimeZone;

public class TextClock extends LinearLayout {
    private Calendar mTime;
    private TextView tvHour;
    private TextView tvMinute;
    private TextView tvDay;
    private TextView tvMonth;
    private TextView tvSecond;
    private TextView tvMeridian;

    private static final int DALEY = 1000;

    public TextClock(Context context) {
        super(context);
    }

    public TextClock(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextClock(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public TextClock(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        final TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.TextClock, defStyleAttr, 0);

        LayoutInflater.from(context).inflate(R.layout.text_clock_layout, this);

        tvHour = (TextView) findViewById(R.id.hour);
        tvMinute = (TextView) findViewById(R.id.minute);
        tvDay = (TextView) findViewById(R.id.day);
        tvMonth = (TextView) findViewById(R.id.month);
        tvMeridian = (TextView) findViewById(R.id.meridian);
        tvSecond = (TextView) findViewById(R.id.second);

        try {
            int color = a.getColor(R.styleable.TextClock_color, Color.BLACK);

            tvHour.setTextColor(color);
            tvMinute.setTextColor(color);
            tvDay.setTextColor(color);
            tvMonth.setTextColor(color);
            tvMeridian.setTextColor(color);
            tvSecond.setTextColor(color);

            findViewById(R.id.separador).setBackgroundColor(color);
        } finally {
            a.recycle();
        }

        init();
    }

    private void init() {
        createTime(TimeZone.getDefault().getID());
        setTime();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setTime();
                getHandler().postDelayed(this, DALEY);
            }
        }, DALEY);
    }

    private void createTime(String timeZone) {
        if (timeZone != null) {
            mTime = Calendar.getInstance(TimeZone.getTimeZone(timeZone));
        } else {
            mTime = Calendar.getInstance();
        }
    }

    private void setTime() {
        mTime.setTimeInMillis(System.currentTimeMillis());

        tvHour.setText(DateFormat.format("hh", mTime));
        tvMinute.setText(DateFormat.format("mm", mTime));
        tvSecond.setText(":" + DateFormat.format("ss", mTime));
        tvMeridian.setText(DateFormat.format("a", mTime));

        tvDay.setText(DateFormat.format("dd", mTime));
        tvMonth.setText(DateFormat.format("MMM", mTime));
    }
}
