package com.example.administrator.myapplication;
import org.litepal.crud.LitePalSupport;
public class CCRA_Tools_Timer extends LitePalSupport {
    private int Id;
    private int DataId;
    private String time1;
    private String time2;
    private String time3;
    private String time4;
    private String remarks;
    public void setId(int id){
        this.Id=id;
    }
    public int getId(){
        return Id;
    }
    public void setDataId(int id){
        this.DataId=id;
    }
    public int getDataId(){
        return DataId;
    }
    public void setTime1(String time){
        this.time1=time;
    }
    public String getTime1(){
        return time1;
    }
    public void setTime2(String time){
        this.time2=time;
    }
    public String getTime2(){
        return time2;
    }
    public void setTime3(String time){
        this.time3=time;
    }
    public String getTime3(){
        return time3;
    }
    public void setTime4(String time){
        this.time4=time;
    }
    public String getTime4(){
        return time4;
    }
    public void setRemarks(String remarks){
        this.remarks=remarks;
    }
    public String getRemarks(){
        return remarks;
    }
}
