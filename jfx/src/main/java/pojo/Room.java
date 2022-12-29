package pojo;

import java.util.ArrayList;

public class Room {
    String roomid;
    int rs;
    String wz;
    String bmsg;

    String kw="123456";

    public String getKw() {
        return kw;
    }

    public void setKw(String kw) {
        this.kw = kw;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public int getRs() {
        return rs;
    }

    public void setRs(int rs) {
        this.rs = rs;
    }

    public String getWz() {
        return wz;
    }

    public void setWz(String wz) {
        this.wz = wz;
    }

    public String getBmsg() {
        return bmsg;
    }

    public void setBmsg(String bmsg) {
        this.bmsg = bmsg;
    }

    public Room() {
    }

    public Room(String roomid, String bmsg) {
        this.roomid = roomid;
        this.bmsg = bmsg;
    }

    public Room(String roomid, int rs, String wz) {
        this.roomid = roomid;
        this.rs = rs;
        this.wz = wz;
    }

    public Room(String roomid, int rs, String wz, String bmsg) {
        this.roomid = roomid;
        this.rs = rs;
        this.wz = wz;
        this.bmsg = bmsg;
    }

    public Room(String roomid, int rs, String wz, String bmsg, String kw) {
        this.roomid = roomid;
        this.rs = rs;
        this.wz = wz;
        this.bmsg = bmsg;
        this.kw = kw;
    }
}
