/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se214h12.nhom4.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stevie
 */
@Entity
@Table(name = "access_token")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccessToken.findAll", query = "SELECT a FROM AccessToken a"),
    @NamedQuery(name = "AccessToken.findById", query = "SELECT a FROM AccessToken a WHERE a.id = :id"),
    @NamedQuery(name = "AccessToken.findByAccessToken", query = "SELECT a FROM AccessToken a WHERE a.accessToken = :accessToken"),
    @NamedQuery(name = "AccessToken.findByExpired", query = "SELECT a FROM AccessToken a WHERE a.expired = :expired")})
public class AccessToken implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 128)
    @Column(name = "access_token")
    private String accessToken;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "expired")
    private Double expired;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public AccessToken() {
    }

    public AccessToken(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Double getExpired() {
        return expired;
    }

    public void setExpired(Double expired) {
        this.expired = expired;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessToken)) {
            return false;
        }
        AccessToken other = (AccessToken) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.se214h12.nhom4.model.AccessToken[ id=" + id + " ]";
    }
    
}
