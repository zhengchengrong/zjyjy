package com.jy.jyjy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jy.jyjy.api.RetrofitService;
import com.jy.jyjy.api.bean.CookieInfo;
import com.jy.jyjy.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.btn_cookie)
     Button btnCookie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnCookie.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_cookie:
                ToastUtils.showToast("btnCookie");
                RetrofitService.getCookie().subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                new Subscriber<CookieInfo>() {
                                    @Override
                                    public void onCompleted() {
                                    }
                                    @Override
                                    public void onError(Throwable e) {
                                        ToastUtils.showToast(e.getMessage());
                                    }
                                    @Override
                                    public void onNext(CookieInfo retrofitEntity) {
                                        ToastUtils.showToast(retrofitEntity.getData());
                                    }
                                    @Override
                                    public void onStart() {
                                        super.onStart();
                                    }
                                }

                        );
                break;
        }
    }
}
