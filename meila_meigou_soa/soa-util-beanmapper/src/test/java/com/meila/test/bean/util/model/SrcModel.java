package com.meila.test.bean.util.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.meila.common.bean.utils.annotaion.MappingField;
import com.meila.test.bean.util.model.junit.model.ModelA;

public class SrcModel {
    private Date date;

    @MappingField({ "modelArr" })
    private ModelA[] modelArr;

    private List<ModelA> modelList;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ModelA[] getModelArr() {
        return modelArr;
    }

    public void setModelArr(ModelA[] modelArr) {
        this.modelArr = modelArr;
    }

    public List<ModelA> getModelList() {
        return modelList;
    }

    public void setModelList(List<ModelA> modelList) {
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
        SrcModel other = (SrcModel) obj;
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
