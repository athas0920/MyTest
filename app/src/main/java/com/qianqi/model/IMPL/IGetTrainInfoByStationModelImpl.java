package com.qianqi.model.IMPL;

import android.util.Log;

import com.qianqi.AsyncCallBack;
import com.qianqi.bean.QueryTrainInfoByStation.TrainInfoBeanByStation;
import com.qianqi.model.IGetTrainInfoByStationModel;
import com.qianqi.netservice.GetTrainInfoByStationApiService;
import com.qianqi.utils.GlobalContants;

//import retrofit.Call;
//import retrofit.Callback;
//import retrofit.GsonConverterFactory;
//import retrofit.Response;
//import retrofit.Retrofit;

/**
 * Created by p on 2017/3/15.
 */

public class IGetTrainInfoByStationModelImpl implements IGetTrainInfoByStationModel {
    @Override
    public void getTrainInfo(String start, String end,String date, final AsyncCallBack callBack) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(GlobalContants.getTrainInfoByStationBaseURL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        GetTrainInfoByStationApiService service = retrofit.create(GetTrainInfoByStationApiService.class);
//        Call<TrainInfoBeanByStation> call = service.getTrainInfoBeanByStation(start,end,date);
//        call.enqueue(new Callback<TrainInfoBeanByStation>() {
//            @Override
//            public void onResponse(Response<TrainInfoBeanByStation> response, Retrofit retrofit) {
//                TrainInfoBeanByStation trainInfoBeanByStation = response.body();
//                if (trainInfoBeanByStation.error_code == 0){
//                    callBack.OnSucess(trainInfoBeanByStation.result.list);
//                }else {
//                    callBack.OnError(trainInfoBeanByStation.reason);
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                Log.i("trainInfoByStationfail", "onFailure: "+t.getMessage());
//            }
//        });
    }
}
