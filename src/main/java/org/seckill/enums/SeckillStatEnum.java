package org.seckill.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 状态描述枚举
 */
public enum SeckillStatEnum {
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATE_REWRITE(-3,"数据篡改");

    private int state;
    private String info;

    private static final Map<Integer,SeckillStatEnum> stateInfo=new HashMap<Integer, SeckillStatEnum>();
    static {
        for (SeckillStatEnum state: values()) {
            stateInfo.put(state.getState(),state);
        }
    }

    SeckillStatEnum(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public String getInfo() {
        return info;
    }

    public static SeckillStatEnum stateOf(int index){
        return stateInfo.get(index);
    }
}
