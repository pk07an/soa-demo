/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.meila.soa.openapi.thrift.product.model;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-05-25")
public class ThriftPageShopModel implements org.apache.thrift.TBase<ThriftPageShopModel, ThriftPageShopModel._Fields>, java.io.Serializable, Cloneable, Comparable<ThriftPageShopModel> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ThriftPageShopModel");

  private static final org.apache.thrift.protocol.TField TOTAL_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("totalNum", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField PAGE_NO_FIELD_DESC = new org.apache.thrift.protocol.TField("pageNo", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField PAGE_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("pageSize", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField SHOPS_FIELD_DESC = new org.apache.thrift.protocol.TField("shops", org.apache.thrift.protocol.TType.LIST, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ThriftPageShopModelStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ThriftPageShopModelTupleSchemeFactory());
  }

  public int totalNum; // required
  public int pageNo; // optional
  public int pageSize; // optional
  public List<ThriftShopModel> shops; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TOTAL_NUM((short)1, "totalNum"),
    PAGE_NO((short)2, "pageNo"),
    PAGE_SIZE((short)3, "pageSize"),
    SHOPS((short)4, "shops");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TOTAL_NUM
          return TOTAL_NUM;
        case 2: // PAGE_NO
          return PAGE_NO;
        case 3: // PAGE_SIZE
          return PAGE_SIZE;
        case 4: // SHOPS
          return SHOPS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __TOTALNUM_ISSET_ID = 0;
  private static final int __PAGENO_ISSET_ID = 1;
  private static final int __PAGESIZE_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.PAGE_NO,_Fields.PAGE_SIZE,_Fields.SHOPS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TOTAL_NUM, new org.apache.thrift.meta_data.FieldMetaData("totalNum", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "int")));
    tmpMap.put(_Fields.PAGE_NO, new org.apache.thrift.meta_data.FieldMetaData("pageNo", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "int")));
    tmpMap.put(_Fields.PAGE_SIZE, new org.apache.thrift.meta_data.FieldMetaData("pageSize", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "int")));
    tmpMap.put(_Fields.SHOPS, new org.apache.thrift.meta_data.FieldMetaData("shops", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ThriftShopModel.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ThriftPageShopModel.class, metaDataMap);
  }

  public ThriftPageShopModel() {
  }

  public ThriftPageShopModel(
    int totalNum)
  {
    this();
    this.totalNum = totalNum;
    setTotalNumIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ThriftPageShopModel(ThriftPageShopModel other) {
    __isset_bitfield = other.__isset_bitfield;
    this.totalNum = other.totalNum;
    this.pageNo = other.pageNo;
    this.pageSize = other.pageSize;
    if (other.isSetShops()) {
      List<ThriftShopModel> __this__shops = new ArrayList<ThriftShopModel>(other.shops.size());
      for (ThriftShopModel other_element : other.shops) {
        __this__shops.add(new ThriftShopModel(other_element));
      }
      this.shops = __this__shops;
    }
  }

  public ThriftPageShopModel deepCopy() {
    return new ThriftPageShopModel(this);
  }

  @Override
  public void clear() {
    setTotalNumIsSet(false);
    this.totalNum = 0;
    setPageNoIsSet(false);
    this.pageNo = 0;
    setPageSizeIsSet(false);
    this.pageSize = 0;
    this.shops = null;
  }

  public int getTotalNum() {
    return this.totalNum;
  }

  public ThriftPageShopModel setTotalNum(int totalNum) {
    this.totalNum = totalNum;
    setTotalNumIsSet(true);
    return this;
  }

  public void unsetTotalNum() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TOTALNUM_ISSET_ID);
  }

  /** Returns true if field totalNum is set (has been assigned a value) and false otherwise */
  public boolean isSetTotalNum() {
    return EncodingUtils.testBit(__isset_bitfield, __TOTALNUM_ISSET_ID);
  }

  public void setTotalNumIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TOTALNUM_ISSET_ID, value);
  }

  public int getPageNo() {
    return this.pageNo;
  }

  public ThriftPageShopModel setPageNo(int pageNo) {
    this.pageNo = pageNo;
    setPageNoIsSet(true);
    return this;
  }

  public void unsetPageNo() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PAGENO_ISSET_ID);
  }

  /** Returns true if field pageNo is set (has been assigned a value) and false otherwise */
  public boolean isSetPageNo() {
    return EncodingUtils.testBit(__isset_bitfield, __PAGENO_ISSET_ID);
  }

  public void setPageNoIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PAGENO_ISSET_ID, value);
  }

  public int getPageSize() {
    return this.pageSize;
  }

  public ThriftPageShopModel setPageSize(int pageSize) {
    this.pageSize = pageSize;
    setPageSizeIsSet(true);
    return this;
  }

  public void unsetPageSize() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PAGESIZE_ISSET_ID);
  }

  /** Returns true if field pageSize is set (has been assigned a value) and false otherwise */
  public boolean isSetPageSize() {
    return EncodingUtils.testBit(__isset_bitfield, __PAGESIZE_ISSET_ID);
  }

  public void setPageSizeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PAGESIZE_ISSET_ID, value);
  }

  public int getShopsSize() {
    return (this.shops == null) ? 0 : this.shops.size();
  }

  public java.util.Iterator<ThriftShopModel> getShopsIterator() {
    return (this.shops == null) ? null : this.shops.iterator();
  }

  public void addToShops(ThriftShopModel elem) {
    if (this.shops == null) {
      this.shops = new ArrayList<ThriftShopModel>();
    }
    this.shops.add(elem);
  }

  public List<ThriftShopModel> getShops() {
    return this.shops;
  }

  public ThriftPageShopModel setShops(List<ThriftShopModel> shops) {
    this.shops = shops;
    return this;
  }

  public void unsetShops() {
    this.shops = null;
  }

  /** Returns true if field shops is set (has been assigned a value) and false otherwise */
  public boolean isSetShops() {
    return this.shops != null;
  }

  public void setShopsIsSet(boolean value) {
    if (!value) {
      this.shops = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TOTAL_NUM:
      if (value == null) {
        unsetTotalNum();
      } else {
        setTotalNum((Integer)value);
      }
      break;

    case PAGE_NO:
      if (value == null) {
        unsetPageNo();
      } else {
        setPageNo((Integer)value);
      }
      break;

    case PAGE_SIZE:
      if (value == null) {
        unsetPageSize();
      } else {
        setPageSize((Integer)value);
      }
      break;

    case SHOPS:
      if (value == null) {
        unsetShops();
      } else {
        setShops((List<ThriftShopModel>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TOTAL_NUM:
      return getTotalNum();

    case PAGE_NO:
      return getPageNo();

    case PAGE_SIZE:
      return getPageSize();

    case SHOPS:
      return getShops();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TOTAL_NUM:
      return isSetTotalNum();
    case PAGE_NO:
      return isSetPageNo();
    case PAGE_SIZE:
      return isSetPageSize();
    case SHOPS:
      return isSetShops();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ThriftPageShopModel)
      return this.equals((ThriftPageShopModel)that);
    return false;
  }

  public boolean equals(ThriftPageShopModel that) {
    if (that == null)
      return false;

    boolean this_present_totalNum = true;
    boolean that_present_totalNum = true;
    if (this_present_totalNum || that_present_totalNum) {
      if (!(this_present_totalNum && that_present_totalNum))
        return false;
      if (this.totalNum != that.totalNum)
        return false;
    }

    boolean this_present_pageNo = true && this.isSetPageNo();
    boolean that_present_pageNo = true && that.isSetPageNo();
    if (this_present_pageNo || that_present_pageNo) {
      if (!(this_present_pageNo && that_present_pageNo))
        return false;
      if (this.pageNo != that.pageNo)
        return false;
    }

    boolean this_present_pageSize = true && this.isSetPageSize();
    boolean that_present_pageSize = true && that.isSetPageSize();
    if (this_present_pageSize || that_present_pageSize) {
      if (!(this_present_pageSize && that_present_pageSize))
        return false;
      if (this.pageSize != that.pageSize)
        return false;
    }

    boolean this_present_shops = true && this.isSetShops();
    boolean that_present_shops = true && that.isSetShops();
    if (this_present_shops || that_present_shops) {
      if (!(this_present_shops && that_present_shops))
        return false;
      if (!this.shops.equals(that.shops))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_totalNum = true;
    list.add(present_totalNum);
    if (present_totalNum)
      list.add(totalNum);

    boolean present_pageNo = true && (isSetPageNo());
    list.add(present_pageNo);
    if (present_pageNo)
      list.add(pageNo);

    boolean present_pageSize = true && (isSetPageSize());
    list.add(present_pageSize);
    if (present_pageSize)
      list.add(pageSize);

    boolean present_shops = true && (isSetShops());
    list.add(present_shops);
    if (present_shops)
      list.add(shops);

    return list.hashCode();
  }

  @Override
  public int compareTo(ThriftPageShopModel other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTotalNum()).compareTo(other.isSetTotalNum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotalNum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.totalNum, other.totalNum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPageNo()).compareTo(other.isSetPageNo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageNo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageNo, other.pageNo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPageSize()).compareTo(other.isSetPageSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageSize, other.pageSize);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetShops()).compareTo(other.isSetShops());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetShops()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.shops, other.shops);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ThriftPageShopModel(");
    boolean first = true;

    sb.append("totalNum:");
    sb.append(this.totalNum);
    first = false;
    if (isSetPageNo()) {
      if (!first) sb.append(", ");
      sb.append("pageNo:");
      sb.append(this.pageNo);
      first = false;
    }
    if (isSetPageSize()) {
      if (!first) sb.append(", ");
      sb.append("pageSize:");
      sb.append(this.pageSize);
      first = false;
    }
    if (isSetShops()) {
      if (!first) sb.append(", ");
      sb.append("shops:");
      if (this.shops == null) {
        sb.append("null");
      } else {
        sb.append(this.shops);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'totalNum' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ThriftPageShopModelStandardSchemeFactory implements SchemeFactory {
    public ThriftPageShopModelStandardScheme getScheme() {
      return new ThriftPageShopModelStandardScheme();
    }
  }

  private static class ThriftPageShopModelStandardScheme extends StandardScheme<ThriftPageShopModel> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ThriftPageShopModel struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TOTAL_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.totalNum = iprot.readI32();
              struct.setTotalNumIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PAGE_NO
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.pageNo = iprot.readI32();
              struct.setPageNoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PAGE_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.pageSize = iprot.readI32();
              struct.setPageSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SHOPS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list44 = iprot.readListBegin();
                struct.shops = new ArrayList<ThriftShopModel>(_list44.size);
                ThriftShopModel _elem45;
                for (int _i46 = 0; _i46 < _list44.size; ++_i46)
                {
                  _elem45 = new ThriftShopModel();
                  _elem45.read(iprot);
                  struct.shops.add(_elem45);
                }
                iprot.readListEnd();
              }
              struct.setShopsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetTotalNum()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'totalNum' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ThriftPageShopModel struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TOTAL_NUM_FIELD_DESC);
      oprot.writeI32(struct.totalNum);
      oprot.writeFieldEnd();
      if (struct.isSetPageNo()) {
        oprot.writeFieldBegin(PAGE_NO_FIELD_DESC);
        oprot.writeI32(struct.pageNo);
        oprot.writeFieldEnd();
      }
      if (struct.isSetPageSize()) {
        oprot.writeFieldBegin(PAGE_SIZE_FIELD_DESC);
        oprot.writeI32(struct.pageSize);
        oprot.writeFieldEnd();
      }
      if (struct.shops != null) {
        if (struct.isSetShops()) {
          oprot.writeFieldBegin(SHOPS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.shops.size()));
            for (ThriftShopModel _iter47 : struct.shops)
            {
              _iter47.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ThriftPageShopModelTupleSchemeFactory implements SchemeFactory {
    public ThriftPageShopModelTupleScheme getScheme() {
      return new ThriftPageShopModelTupleScheme();
    }
  }

  private static class ThriftPageShopModelTupleScheme extends TupleScheme<ThriftPageShopModel> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ThriftPageShopModel struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.totalNum);
      BitSet optionals = new BitSet();
      if (struct.isSetPageNo()) {
        optionals.set(0);
      }
      if (struct.isSetPageSize()) {
        optionals.set(1);
      }
      if (struct.isSetShops()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetPageNo()) {
        oprot.writeI32(struct.pageNo);
      }
      if (struct.isSetPageSize()) {
        oprot.writeI32(struct.pageSize);
      }
      if (struct.isSetShops()) {
        {
          oprot.writeI32(struct.shops.size());
          for (ThriftShopModel _iter48 : struct.shops)
          {
            _iter48.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ThriftPageShopModel struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.totalNum = iprot.readI32();
      struct.setTotalNumIsSet(true);
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.pageNo = iprot.readI32();
        struct.setPageNoIsSet(true);
      }
      if (incoming.get(1)) {
        struct.pageSize = iprot.readI32();
        struct.setPageSizeIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list49 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.shops = new ArrayList<ThriftShopModel>(_list49.size);
          ThriftShopModel _elem50;
          for (int _i51 = 0; _i51 < _list49.size; ++_i51)
          {
            _elem50 = new ThriftShopModel();
            _elem50.read(iprot);
            struct.shops.add(_elem50);
          }
        }
        struct.setShopsIsSet(true);
      }
    }
  }

}

