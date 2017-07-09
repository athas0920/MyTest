package com.qianqi.fragment;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qianqi.R;
import com.qianqi.activity.BroadcastChargeWebview;
import com.qianqi.activity.CalendarActivity;
import com.qianqi.activity.ElectricChargeWebview;
import com.qianqi.activity.LoginActivity;
import com.qianqi.activity.MobileChargeWebpager;
import com.qianqi.activity.NoVehicleViolationActivity;
import com.qianqi.activity.SheBao;
import com.qianqi.activity.VehicleViolationQueryActivity;
import com.qianqi.activity.VehicleViolationResultActivity;
import com.qianqi.bean.VehicleViolationBean.VehicleViolationResult;
import com.qianqi.presenter.IGetVehicleViolationInfoPresenter;
import com.qianqi.presenter.Impl.IGetVehicleViolationInfoPresenterImpl;
import com.qianqi.view.GetVehicleViolationInfo;

import java.io.Serializable;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by p on 2017/3/21.
 */

public class MyHomeFragment extends Fragment implements GetVehicleViolationInfo {
    //real name login and regex field
    @InjectView(R.id.real_name)
    TextView real_name;
    @InjectView(R.id.head_portrait)
    ImageView head;
    //link to electric_charge,broadcast_charge,mobile_charge
    @InjectView(R.id.mobile_charge)
    LinearLayout mobile_charge;
    @InjectView(R.id.electric_charge)
    LinearLayout electric_charge;
    @InjectView(R.id.broadcast_charge)
    LinearLayout broadcast_charge;

    //vehicle violation query field
    @InjectView(R.id.car_Add)
    TextView add;
    @InjectView(R.id.car)
    LinearLayout car;
    SQLiteDatabase db;
    SQLiteOpenHelper helper;
    IGetVehicleViolationInfoPresenter presenter = new IGetVehicleViolationInfoPresenterImpl(this);

    //shebao
    @InjectView(R.id.shebao)
    LinearLayout shebao;
    //lytcalendar
    @InjectView(R.id.lytcalendar)
    LinearLayout lytcalendar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_home_fragment, null);
        ButterKnife.inject(this, view);
        //login and regex about
        LoginAndRegex();
        //set realname
        SetRealName();
        //charge about
        ChargeLink();
        //vehicle violation query about
        VehicleViolation();
        //Shebao
        Shebao();

        calendar();
        return view;
    }

    private void calendar() {
        lytcalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CalendarActivity.class));
            }
        });

    }

    private void Shebao() {
        shebao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SheBao.class));
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse("https://billcloud.unionpay.com/ccfront/entry/query?category=S2&insId=1900_0002"));
//                startActivity(i);
            }
        });

    }

    private void VehicleViolation() {
//        helper = new DrivingDataBase(getActivity());
//        db = helper.getReadableDatabase();
//        Cursor c = db.rawQuery("select * from drive",null);
//        String carNo ;
//        String frameNo;
//        String engineNo;
//        if (c.moveToFirst()){
//            do {
//               carNo =  c.getString(c.getColumnIndex("carNo"));
//                Log.i("carNo", "VehicleViolation: "+carNo);
//                frameNo = c.getString(c.getColumnIndex("frameNo"));
//                engineNo = c.getString(c.getColumnIndex("engineNo"));
//                if (carNo == null  ){
//                    add.setVisibility(View.INVISIBLE);
//
//                }else {
//                    if (frameNo != null && engineNo != null){
//                        final String finalFrameNo = frameNo;
//                        final String finalEngineNo = engineNo;
//                        final String finalCarNo = carNo;
//                        car.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                presenter.IGetVehicleViolationInfoPresenter(finalFrameNo, finalEngineNo, finalCarNo);
//                            }
//                        });
//
//                    }
//                }
//            }while (c.moveToNext());
//        }
//        c.close();
//        db.close();

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), VehicleViolationQueryActivity.class));
            }
        });
    }

    private void ChargeLink() {
        mobile_charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MobileChargeWebpager.class));
            }
        });
        electric_charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ElectricChargeWebview.class));
            }
        });
        broadcast_charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BroadcastChargeWebview.class));
            }
        });
    }

    private void SetRealName() {
        Intent intent = getActivity().getIntent();
        String name = intent.getStringExtra("name");
        real_name.setText(name);
    }

    private void LoginAndRegex() {
        real_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
    }

    @Override
    public void getVehicleViolationInfoSucess(List<VehicleViolationResult> results) {
        Intent intent = new Intent(getActivity(), VehicleViolationResultActivity.class);
        Bundle b = new Bundle();
        b.putSerializable("vehicleviolation", (Serializable) results);
        startActivity(intent);
    }

    @Override
    public void getVehicleViolationInfoError(String Msg) {
        Toast.makeText(getActivity(), "查询失败，请确认后重试！", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void NoVehicleViolationBehavior(String reason) {
        startActivity(new Intent(getActivity(), NoVehicleViolationActivity.class));

    }
}
