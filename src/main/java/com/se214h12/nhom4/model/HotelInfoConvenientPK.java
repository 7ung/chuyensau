/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se214h12.nhom4.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Stevie
 */
@Embeddable
public class HotelInfoConvenientPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "hotel_id")
    private int hotelId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "convenient_id")
    private int convenientId;

    public HotelInfoConvenientPK() {
    }

    public HotelInfoConvenientPK(int hotelId, int convenientId) {
        this.hotelId = hotelId;
        this.convenientId = convenientId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getConvenientId() {
        return convenientId;
    }

    public void setConvenientId(int convenientId) {
        this.convenientId = convenientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) hotelId;
        hash += (int) convenientId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HotelInfoConvenientPK)) {
            return false;
        }
        HotelInfoConvenientPK other = (HotelInfoConvenientPK) object;
        if (this.hotelId != other.hotelId) {
            return false;
        }
        if (this.convenientId != other.convenientId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.se214h12.nhom4.model.HotelInfoConvenientPK[ hotelId=" + hotelId + ", convenientId=" + convenientId + " ]";
    }
    
}
