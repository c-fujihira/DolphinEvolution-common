/*
 * Copyright (C) 2014 S&I Co.,Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package open.dolphin.infomodel;

import java.util.Date;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

/**
 * ServerConfigrationModel サーバ設定 Model
 *
 * @author Chikara Fujihira <fujihirach@sandi.co.jp>, S&I Co.,Ltd.
 */
@Entity
@Table(name = "d_server_cfg")
@TransactionManagement(TransactionManagementType.BEAN)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ServerConfigrationModel implements java.io.Serializable {

    private static final String DEFAULT_INIT_TIME = "0300";
    private static final String DEFAULT_RESTART_TIME = "0000";
    private static final boolean DEFAULT_STATUS_FLAG = true;
    private static final boolean DEFAULT_ZANRYO_FLAG = true;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String initTime;

    @Column(nullable = false)
    private String restartTime;

    @Column(nullable = false)
    @Type(type = "true_false")
    private boolean statusFlag;

    @Column(nullable = false)
    @Type(type = "true_false")
    private boolean zanryoFlag;

    @Column(nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date supDate;

    @Column(nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date initDate;

    @Column(nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date restartDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInitTime() {
        return initTime;
    }

    public void setInitTime(String t) {
        this.initTime = t;
    }

    public void setDefaultInitTime() {
        this.initTime = DEFAULT_INIT_TIME;
    }

    public String getRestartTime() {
        return restartTime;
    }

    public void setRestartTime(String t) {
        this.restartTime = t;
    }

    public void setDefaultRestartTime() {
        this.restartTime = DEFAULT_RESTART_TIME;
    }

    public boolean getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(boolean t) {
        this.statusFlag = t;
    }

    public void setDefaultStatusFlag() {
        this.statusFlag = DEFAULT_STATUS_FLAG;
    }

    public boolean getZanryoFlag() {
        return zanryoFlag;
    }

    public void setZanryoFlag(boolean t) {
        this.zanryoFlag = t;
    }

    public void setDefaultZanryoFlag() {
        this.zanryoFlag = DEFAULT_ZANRYO_FLAG;
    }

    public Date getExecDate() {
        return supDate;
    }

    public void setExecDate() {
        Date tm = new Date();
        this.supDate = tm;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate() {
        Date tm = new Date();
        this.initDate = tm;
    }

    public Date getRestartDate() {
        return restartDate;
    }

    public void setRestartDate() {
        Date tm = new Date();
        this.restartDate = tm;
    }

}
