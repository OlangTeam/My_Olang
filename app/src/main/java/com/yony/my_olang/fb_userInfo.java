package com.yony.my_olang;

public class fb_userInfo {
    String id; //사용자 아이디
    String password; //사용자 비밀번호
    String name; //사용자 이름
    String email; //사용자 이메일
    String address; //사용자 주소
    String hp; //사용자 핸드폰번호

    public fb_userInfo(){}

    //getter(), setter()
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    //값을 추가할때 쓰는 함수, MainActivity에서 addanimal함수에서 사용할 것임.
    public fb_userInfo(String id, String pass, String name, String email, String address, String hp) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
        this.hp = hp;
    }
}
