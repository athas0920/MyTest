package com.qianqi.view;

import com.qianqi.bean.VehicleViolationBean.VehicleViolationResult;

import java.util.List;

/**
 * Created by p on 2017/3/15.
 */

public interface GetVehicleViolationInfo {
    public void getVehicleViolationInfoSucess(List<VehicleViolationResult> results);
    public void getVehicleViolationInfoError(String Msg);
    public void NoVehicleViolationBehavior(String reason);
}
