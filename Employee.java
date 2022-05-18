/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau4;

import java.io.Serializable;

/**
 *
 * @author Softech
 */
public class Employee  implements Serializable{
    int mId;
    String mName;
    String mAddress;
    int mAge;

    public Employee(int mId, String mName, String mAddress, int mAge) {
        this.mId = mId;
        this.mName = mName;
        this.mAddress = mAddress;
        this.mAge = mAge;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }
    
    public void display(){
        System.out.printf("%-10d %-20s %-20s %-10d\n",mId, mName, mAddress, mAge);
    }
}
