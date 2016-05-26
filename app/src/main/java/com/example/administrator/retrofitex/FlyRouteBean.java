package com.example.administrator.retrofitex;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016/5/23.
 */
public class FlyRouteBean{

    /**
     * Id : string
     * DeviceId : string
     * Name : string
     * SumDistance : 0
     * RouteNo : string
     * SumPoints : 0
     * SetupTime : 2016-05-23T06:20:50.254Z
     * UsedTime : 0
     * Points : [{"Id":"string","RouteNo":"string","Name":"string","Longitude":"string","Latitude":"string","Height":0,"Distance":0,"Yaw":0,"Pitch":0,"Speed":0,"Usedtime":0}]
     */

    public String Id;
    public String DeviceId;
    public String Name;
    public double SumDistance;
    public String RouteNo;
    public int SumPoints;
    public String SetupTime;
    public double UsedTime;
    /**
     * Id : string
     * RouteNo : string
     * Name : string
     * Longitude : string
     * Latitude : string
     * Height : 0
     * Distance : 0
     * Yaw : 0
     * Pitch : 0
     * Speed : 0
     * Usedtime : 0
     */

    public List<PointsBean> Points;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String DeviceId) {
        this.DeviceId = DeviceId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getSumDistance() {
        return SumDistance;
    }

    public void setSumDistance(double SumDistance) {
        this.SumDistance = SumDistance;
    }

    public String getRouteNo() {
        return RouteNo;
    }

    public void setRouteNo(String RouteNo) {
        this.RouteNo = RouteNo;
    }

    public int getSumPoints() {
        return SumPoints;
    }

    public void setSumPoints(int SumPoints) {
        this.SumPoints = SumPoints;
    }

    public String getSetupTime() {
        return SetupTime;
    }

    public void setSetupTime(String SetupTime) {
        this.SetupTime = SetupTime;
    }

    public double getUsedTime() {
        return UsedTime;
    }

    public void setUsedTime(double UsedTime) {
        this.UsedTime = UsedTime;
    }

    public List<PointsBean> getPoints() {
        return Points;
    }

    public void setPoints(List<PointsBean> Points) {
        this.Points = Points;
    }

    public static class PointsBean implements Parcelable {
        public String Id;
        public String RouteNo;
        public String Name;
        public String Longitude;
        public String Latitude;
        public double Height;
        public double Distance;
        public double Yaw;
        public double Pitch;
        public double Speed;
        public double Usedtime;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getRouteNo() {
            return RouteNo;
        }

        public void setRouteNo(String RouteNo) {
            this.RouteNo = RouteNo;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getLongitude() {
            return Longitude;
        }

        public void setLongitude(String Longitude) {
            this.Longitude = Longitude;
        }

        public String getLatitude() {
            return Latitude;
        }

        public void setLatitude(String Latitude) {
            this.Latitude = Latitude;
        }

        public double getHeight() {
            return Height;
        }

        public void setHeight(double Height) {
            this.Height = Height;
        }

        public double getDistance() {
            return Distance;
        }

        public void setDistance(double Distance) {
            this.Distance = Distance;
        }

        public double getYaw() {
            return Yaw;
        }

        public void setYaw(double Yaw) {
            this.Yaw = Yaw;
        }

        public double getPitch() {
            return Pitch;
        }

        public void setPitch(double Pitch) {
            this.Pitch = Pitch;
        }

        public double getSpeed() {
            return Speed;
        }

        public void setSpeed(double Speed) {
            this.Speed = Speed;
        }

        public double getUsedtime() {
            return Usedtime;
        }

        public void setUsedtime(double Usedtime) {
            this.Usedtime = Usedtime;
        }

        @Override
        public String toString() {
            return "PointsBean{" +
                    "Id='" + Id + '\'' +
                    ", RouteNo='" + RouteNo + '\'' +
                    ", Name='" + Name + '\'' +
                    ", Longitude='" + Longitude + '\'' +
                    ", Latitude='" + Latitude + '\'' +
                    ", Height=" + Height +
                    ", Distance=" + Distance +
                    ", Yaw=" + Yaw +
                    ", Pitch=" + Pitch +
                    ", Speed=" + Speed +
                    ", Usedtime=" + Usedtime +
                    '}';
        }

        @Override
    	public void writeToParcel(Parcel dest, int flags) {
    		// TODO Auto-generated method stub
    		dest.writeString(Id);
    		dest.writeString(RouteNo);
    		dest.writeString(Name);
    		dest.writeString(Longitude);
    		dest.writeString(Latitude);
    		dest.writeDouble(Height);		
    		dest.writeDouble(Distance);
    		dest.writeDouble(Yaw);
    		dest.writeDouble(Pitch);
    		dest.writeDouble(Speed);
    		dest.writeDouble(Usedtime);		
    	}
    	public static final Creator<PointsBean> CREATOR=new Creator<PointsBean>() {

    		@Override
    		public PointsBean createFromParcel(Parcel source) {
    			// TODO Auto-generated method stub
    			PointsBean pointsBean=new PointsBean();
    			pointsBean.setId(source.readString());
    			pointsBean.setRouteNo(source.readString());
    			pointsBean.setName(source.readString());
    			pointsBean.setLongitude(source.readString());
    			pointsBean.setLatitude(source.readString());
    			pointsBean.setHeight(source.readInt());
    			pointsBean.setDistance(source.readInt());
    			pointsBean.setYaw(source.readInt());
    			pointsBean.setPitch(source.readInt());
    			pointsBean.setSpeed(source.readInt());
    			pointsBean.setUsedtime(source.readInt());
    			return pointsBean;
    		}

    		@Override
    		public PointsBean[] newArray(int size) {
    			// TODO Auto-generated method stub
    			return new PointsBean[size];
    		}
    		
    	};

		@Override
		public int describeContents() {
			// TODO Auto-generated method stub
			return 0;
		}
    }

    @Override
    public String toString() {
        return "FlyRouteBean{" +
                "Id='" + Id + '\'' +
                ", DeviceId='" + DeviceId + '\'' +
                ", Name='" + Name + '\'' +
                ", SumDistance=" + SumDistance +
                ", RouteNo='" + RouteNo + '\'' +
                ", SumPoints=" + SumPoints +
                ", SetupTime='" + SetupTime + '\'' +
                ", UsedTime=" + UsedTime +
                ", Points=" + Points +
                '}';
    }

	
}

