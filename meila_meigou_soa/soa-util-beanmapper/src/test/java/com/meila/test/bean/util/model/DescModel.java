package com.meila.test.bean.util.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.meila.test.bean.util.model.junit.model.ModelB;

public class DescModel {
    private String date;

    private ModelB[] modelArr;

    private List<ModelB> modelList;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ModelB[] getModelArr() {
        return modelArr;
    }

    public void setModelArr(ModelB[] modelArr) {
        this.modelArr = modelArr;
    }

    public List<ModelB> getModelList() {
        return modelList;
    }

    public void setModelList(List<ModelB> modelList) {
        this.modelList = modelList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(modelArr);
        result = prime * result + ((modelList == null) ? 0 : modelList.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DescModel other = (DescModel) obj;
        if (!Arrays.equals(modelArr, other.modelArr))
            return false;
        if (modelList == null) {
            if (other.modelList != null)
                return false;
        } else if (!modelList.equals(other.modelList))
            return false;
        return true;
    }

}
