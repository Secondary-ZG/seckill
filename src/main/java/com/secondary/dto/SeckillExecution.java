package com.secondary.dto;import com.secondary.entity.SuccessKilled;/** * 分装秒杀执行后的结果 * Created by Secondary on 2017/8/5 */public class SeckillExecution {    //id    private long seckillId;    //秒杀执行结果状态    private int state;    //状态表示    private String stateInfo;    //秒杀成功对象    private SuccessKilled successKilled;    public long getSeckillId() {        return seckillId;    }    public void setSeckillId(long seckillId) {        this.seckillId = seckillId;    }    public int getState() {        return state;    }    public void setState(int state) {        this.state = state;    }    public String getStateInfo() {        return stateInfo;    }    public void setStateInfo(String stateInfo) {        this.stateInfo = stateInfo;    }    public SuccessKilled getSuccessKilled() {        return successKilled;    }    public void setSuccessKilled(SuccessKilled successKilled) {        this.successKilled = successKilled;    }    //成功状态下的构造方法    public SeckillExecution(long seckillId, int state, String stateInfo, SuccessKilled successKilled) {        this.seckillId = seckillId;        this.state = state;        this.stateInfo = stateInfo;        this.successKilled = successKilled;    }    //失败状态下的构造方法    public SeckillExecution(long seckillId, int state, String stateInfo) {        this.seckillId = seckillId;        this.state = state;        this.stateInfo = stateInfo;    }}