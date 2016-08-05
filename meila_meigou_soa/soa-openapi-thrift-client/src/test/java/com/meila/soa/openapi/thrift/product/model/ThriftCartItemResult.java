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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-05-12")
public class ThriftCartItemResult implements org.apache.thrift.TBase<ThriftCartItemResult, ThriftCartItemResult._Fields>, java.io.Serializable, Cloneable, Comparable<ThriftCartItemResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ThriftCartItemResult");

  private static final org.apache.thrift.protocol.TField CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("code", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField DESCRIPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("description", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField TID_FIELD_DESC = new org.apache.thrift.protocol.TField("tid", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField ITEM_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("itemId", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField PRODUCT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("productId", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField SKU_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("skuId", org.apache.thrift.protocol.TType.I64, (short)6);
  private static final org.apache.thrift.protocol.TField PRICE_FIELD_DESC = new org.apache.thrift.protocol.TField("price", org.apache.thrift.protocol.TType.DOUBLE, (short)7);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ThriftCartItemResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ThriftCartItemResultTupleSchemeFactory());
  }

  public int code; // required
  public String description; // optional
  public String tid; // optional
  public long itemId; // optional
  public long productId; // optional
  public long skuId; // optional
  public double price; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CODE((short)1, "code"),
    DESCRIPTION((short)2, "description"),
    TID((short)3, "tid"),
    ITEM_ID((short)4, "itemId"),
    PRODUCT_ID((short)5, "productId"),
    SKU_ID((short)6, "skuId"),
    PRICE((short)7, "price");

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
        case 1: // CODE
          return CODE;
        case 2: // DESCRIPTION
          return DESCRIPTION;
        case 3: // TID
          return TID;
        case 4: // ITEM_ID
          return ITEM_ID;
        case 5: // PRODUCT_ID
          return PRODUCT_ID;
        case 6: // SKU_ID
          return SKU_ID;
        case 7: // PRICE
          return PRICE;
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
  private static final int __CODE_ISSET_ID = 0;
  private static final int __ITEMID_ISSET_ID = 1;
  private static final int __PRODUCTID_ISSET_ID = 2;
  private static final int __SKUID_ISSET_ID = 3;
  private static final int __PRICE_ISSET_ID = 4;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.DESCRIPTION,_Fields.TID,_Fields.ITEM_ID,_Fields.PRODUCT_ID,_Fields.SKU_ID,_Fields.PRICE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CODE, new org.apache.thrift.meta_data.FieldMetaData("code", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "int")));
    tmpMap.put(_Fields.DESCRIPTION, new org.apache.thrift.meta_data.FieldMetaData("description", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TID, new org.apache.thrift.meta_data.FieldMetaData("tid", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ITEM_ID, new org.apache.thrift.meta_data.FieldMetaData("itemId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "long")));
    tmpMap.put(_Fields.PRODUCT_ID, new org.apache.thrift.meta_data.FieldMetaData("productId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "long")));
    tmpMap.put(_Fields.SKU_ID, new org.apache.thrift.meta_data.FieldMetaData("skuId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "long")));
    tmpMap.put(_Fields.PRICE, new org.apache.thrift.meta_data.FieldMetaData("price", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ThriftCartItemResult.class, metaDataMap);
  }

  public ThriftCartItemResult() {
  }

  public ThriftCartItemResult(
    int code)
  {
    this();
    this.code = code;
    setCodeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ThriftCartItemResult(ThriftCartItemResult other) {
    __isset_bitfield = other.__isset_bitfield;
    this.code = other.code;
    if (other.isSetDescription()) {
      this.description = other.description;
    }
    if (other.isSetTid()) {
      this.tid = other.tid;
    }
    this.itemId = other.itemId;
    this.productId = other.productId;
    this.skuId = other.skuId;
    this.price = other.price;
  }

  public ThriftCartItemResult deepCopy() {
    return new ThriftCartItemResult(this);
  }

  @Override
  public void clear() {
    setCodeIsSet(false);
    this.code = 0;
    this.description = null;
    this.tid = null;
    setItemIdIsSet(false);
    this.itemId = 0;
    setProductIdIsSet(false);
    this.productId = 0;
    setSkuIdIsSet(false);
    this.skuId = 0;
    setPriceIsSet(false);
    this.price = 0.0;
  }

  public int getCode() {
    return this.code;
  }

  public ThriftCartItemResult setCode(int code) {
    this.code = code;
    setCodeIsSet(true);
    return this;
  }

  public void unsetCode() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CODE_ISSET_ID);
  }

  /** Returns true if field code is set (has been assigned a value) and false otherwise */
  public boolean isSetCode() {
    return EncodingUtils.testBit(__isset_bitfield, __CODE_ISSET_ID);
  }

  public void setCodeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CODE_ISSET_ID, value);
  }

  public String getDescription() {
    return this.description;
  }

  public ThriftCartItemResult setDescription(String description) {
    this.description = description;
    return this;
  }

  public void unsetDescription() {
    this.description = null;
  }

  /** Returns true if field description is set (has been assigned a value) and false otherwise */
  public boolean isSetDescription() {
    return this.description != null;
  }

  public void setDescriptionIsSet(boolean value) {
    if (!value) {
      this.description = null;
    }
  }

  public String getTid() {
    return this.tid;
  }

  public ThriftCartItemResult setTid(String tid) {
    this.tid = tid;
    return this;
  }

  public void unsetTid() {
    this.tid = null;
  }

  /** Returns true if field tid is set (has been assigned a value) and false otherwise */
  public boolean isSetTid() {
    return this.tid != null;
  }

  public void setTidIsSet(boolean value) {
    if (!value) {
      this.tid = null;
    }
  }

  public long getItemId() {
    return this.itemId;
  }

  public ThriftCartItemResult setItemId(long itemId) {
    this.itemId = itemId;
    setItemIdIsSet(true);
    return this;
  }

  public void unsetItemId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ITEMID_ISSET_ID);
  }

  /** Returns true if field itemId is set (has been assigned a value) and false otherwise */
  public boolean isSetItemId() {
    return EncodingUtils.testBit(__isset_bitfield, __ITEMID_ISSET_ID);
  }

  public void setItemIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ITEMID_ISSET_ID, value);
  }

  public long getProductId() {
    return this.productId;
  }

  public ThriftCartItemResult setProductId(long productId) {
    this.productId = productId;
    setProductIdIsSet(true);
    return this;
  }

  public void unsetProductId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PRODUCTID_ISSET_ID);
  }

  /** Returns true if field productId is set (has been assigned a value) and false otherwise */
  public boolean isSetProductId() {
    return EncodingUtils.testBit(__isset_bitfield, __PRODUCTID_ISSET_ID);
  }

  public void setProductIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PRODUCTID_ISSET_ID, value);
  }

  public long getSkuId() {
    return this.skuId;
  }

  public ThriftCartItemResult setSkuId(long skuId) {
    this.skuId = skuId;
    setSkuIdIsSet(true);
    return this;
  }

  public void unsetSkuId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SKUID_ISSET_ID);
  }

  /** Returns true if field skuId is set (has been assigned a value) and false otherwise */
  public boolean isSetSkuId() {
    return EncodingUtils.testBit(__isset_bitfield, __SKUID_ISSET_ID);
  }

  public void setSkuIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SKUID_ISSET_ID, value);
  }

  public double getPrice() {
    return this.price;
  }

  public ThriftCartItemResult setPrice(double price) {
    this.price = price;
    setPriceIsSet(true);
    return this;
  }

  public void unsetPrice() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PRICE_ISSET_ID);
  }

  /** Returns true if field price is set (has been assigned a value) and false otherwise */
  public boolean isSetPrice() {
    return EncodingUtils.testBit(__isset_bitfield, __PRICE_ISSET_ID);
  }

  public void setPriceIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PRICE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CODE:
      if (value == null) {
        unsetCode();
      } else {
        setCode((Integer)value);
      }
      break;

    case DESCRIPTION:
      if (value == null) {
        unsetDescription();
      } else {
        setDescription((String)value);
      }
      break;

    case TID:
      if (value == null) {
        unsetTid();
      } else {
        setTid((String)value);
      }
      break;

    case ITEM_ID:
      if (value == null) {
        unsetItemId();
      } else {
        setItemId((Long)value);
      }
      break;

    case PRODUCT_ID:
      if (value == null) {
        unsetProductId();
      } else {
        setProductId((Long)value);
      }
      break;

    case SKU_ID:
      if (value == null) {
        unsetSkuId();
      } else {
        setSkuId((Long)value);
      }
      break;

    case PRICE:
      if (value == null) {
        unsetPrice();
      } else {
        setPrice((Double)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CODE:
      return getCode();

    case DESCRIPTION:
      return getDescription();

    case TID:
      return getTid();

    case ITEM_ID:
      return getItemId();

    case PRODUCT_ID:
      return getProductId();

    case SKU_ID:
      return getSkuId();

    case PRICE:
      return getPrice();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CODE:
      return isSetCode();
    case DESCRIPTION:
      return isSetDescription();
    case TID:
      return isSetTid();
    case ITEM_ID:
      return isSetItemId();
    case PRODUCT_ID:
      return isSetProductId();
    case SKU_ID:
      return isSetSkuId();
    case PRICE:
      return isSetPrice();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ThriftCartItemResult)
      return this.equals((ThriftCartItemResult)that);
    return false;
  }

  public boolean equals(ThriftCartItemResult that) {
    if (that == null)
      return false;

    boolean this_present_code = true;
    boolean that_present_code = true;
    if (this_present_code || that_present_code) {
      if (!(this_present_code && that_present_code))
        return false;
      if (this.code != that.code)
        return false;
    }

    boolean this_present_description = true && this.isSetDescription();
    boolean that_present_description = true && that.isSetDescription();
    if (this_present_description || that_present_description) {
      if (!(this_present_description && that_present_description))
        return false;
      if (!this.description.equals(that.description))
        return false;
    }

    boolean this_present_tid = true && this.isSetTid();
    boolean that_present_tid = true && that.isSetTid();
    if (this_present_tid || that_present_tid) {
      if (!(this_present_tid && that_present_tid))
        return false;
      if (!this.tid.equals(that.tid))
        return false;
    }

    boolean this_present_itemId = true && this.isSetItemId();
    boolean that_present_itemId = true && that.isSetItemId();
    if (this_present_itemId || that_present_itemId) {
      if (!(this_present_itemId && that_present_itemId))
        return false;
      if (this.itemId != that.itemId)
        return false;
    }

    boolean this_present_productId = true && this.isSetProductId();
    boolean that_present_productId = true && that.isSetProductId();
    if (this_present_productId || that_present_productId) {
      if (!(this_present_productId && that_present_productId))
        return false;
      if (this.productId != that.productId)
        return false;
    }

    boolean this_present_skuId = true && this.isSetSkuId();
    boolean that_present_skuId = true && that.isSetSkuId();
    if (this_present_skuId || that_present_skuId) {
      if (!(this_present_skuId && that_present_skuId))
        return false;
      if (this.skuId != that.skuId)
        return false;
    }

    boolean this_present_price = true && this.isSetPrice();
    boolean that_present_price = true && that.isSetPrice();
    if (this_present_price || that_present_price) {
      if (!(this_present_price && that_present_price))
        return false;
      if (this.price != that.price)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_code = true;
    list.add(present_code);
    if (present_code)
      list.add(code);

    boolean present_description = true && (isSetDescription());
    list.add(present_description);
    if (present_description)
      list.add(description);

    boolean present_tid = true && (isSetTid());
    list.add(present_tid);
    if (present_tid)
      list.add(tid);

    boolean present_itemId = true && (isSetItemId());
    list.add(present_itemId);
    if (present_itemId)
      list.add(itemId);

    boolean present_productId = true && (isSetProductId());
    list.add(present_productId);
    if (present_productId)
      list.add(productId);

    boolean present_skuId = true && (isSetSkuId());
    list.add(present_skuId);
    if (present_skuId)
      list.add(skuId);

    boolean present_price = true && (isSetPrice());
    list.add(present_price);
    if (present_price)
      list.add(price);

    return list.hashCode();
  }

  @Override
  public int compareTo(ThriftCartItemResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCode()).compareTo(other.isSetCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.code, other.code);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDescription()).compareTo(other.isSetDescription());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDescription()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.description, other.description);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTid()).compareTo(other.isSetTid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tid, other.tid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetItemId()).compareTo(other.isSetItemId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetItemId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.itemId, other.itemId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetProductId()).compareTo(other.isSetProductId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProductId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.productId, other.productId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSkuId()).compareTo(other.isSetSkuId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSkuId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.skuId, other.skuId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPrice()).compareTo(other.isSetPrice());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPrice()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.price, other.price);
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
    StringBuilder sb = new StringBuilder("ThriftCartItemResult(");
    boolean first = true;

    sb.append("code:");
    sb.append(this.code);
    first = false;
    if (isSetDescription()) {
      if (!first) sb.append(", ");
      sb.append("description:");
      if (this.description == null) {
        sb.append("null");
      } else {
        sb.append(this.description);
      }
      first = false;
    }
    if (isSetTid()) {
      if (!first) sb.append(", ");
      sb.append("tid:");
      if (this.tid == null) {
        sb.append("null");
      } else {
        sb.append(this.tid);
      }
      first = false;
    }
    if (isSetItemId()) {
      if (!first) sb.append(", ");
      sb.append("itemId:");
      sb.append(this.itemId);
      first = false;
    }
    if (isSetProductId()) {
      if (!first) sb.append(", ");
      sb.append("productId:");
      sb.append(this.productId);
      first = false;
    }
    if (isSetSkuId()) {
      if (!first) sb.append(", ");
      sb.append("skuId:");
      sb.append(this.skuId);
      first = false;
    }
    if (isSetPrice()) {
      if (!first) sb.append(", ");
      sb.append("price:");
      sb.append(this.price);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'code' because it's a primitive and you chose the non-beans generator.
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

  private static class ThriftCartItemResultStandardSchemeFactory implements SchemeFactory {
    public ThriftCartItemResultStandardScheme getScheme() {
      return new ThriftCartItemResultStandardScheme();
    }
  }

  private static class ThriftCartItemResultStandardScheme extends StandardScheme<ThriftCartItemResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ThriftCartItemResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.code = iprot.readI32();
              struct.setCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DESCRIPTION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.description = iprot.readString();
              struct.setDescriptionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.tid = iprot.readString();
              struct.setTidIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ITEM_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.itemId = iprot.readI64();
              struct.setItemIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // PRODUCT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.productId = iprot.readI64();
              struct.setProductIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // SKU_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.skuId = iprot.readI64();
              struct.setSkuIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // PRICE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.price = iprot.readDouble();
              struct.setPriceIsSet(true);
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
      if (!struct.isSetCode()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'code' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ThriftCartItemResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(CODE_FIELD_DESC);
      oprot.writeI32(struct.code);
      oprot.writeFieldEnd();
      if (struct.description != null) {
        if (struct.isSetDescription()) {
          oprot.writeFieldBegin(DESCRIPTION_FIELD_DESC);
          oprot.writeString(struct.description);
          oprot.writeFieldEnd();
        }
      }
      if (struct.tid != null) {
        if (struct.isSetTid()) {
          oprot.writeFieldBegin(TID_FIELD_DESC);
          oprot.writeString(struct.tid);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetItemId()) {
        oprot.writeFieldBegin(ITEM_ID_FIELD_DESC);
        oprot.writeI64(struct.itemId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetProductId()) {
        oprot.writeFieldBegin(PRODUCT_ID_FIELD_DESC);
        oprot.writeI64(struct.productId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetSkuId()) {
        oprot.writeFieldBegin(SKU_ID_FIELD_DESC);
        oprot.writeI64(struct.skuId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetPrice()) {
        oprot.writeFieldBegin(PRICE_FIELD_DESC);
        oprot.writeDouble(struct.price);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ThriftCartItemResultTupleSchemeFactory implements SchemeFactory {
    public ThriftCartItemResultTupleScheme getScheme() {
      return new ThriftCartItemResultTupleScheme();
    }
  }

  private static class ThriftCartItemResultTupleScheme extends TupleScheme<ThriftCartItemResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ThriftCartItemResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.code);
      BitSet optionals = new BitSet();
      if (struct.isSetDescription()) {
        optionals.set(0);
      }
      if (struct.isSetTid()) {
        optionals.set(1);
      }
      if (struct.isSetItemId()) {
        optionals.set(2);
      }
      if (struct.isSetProductId()) {
        optionals.set(3);
      }
      if (struct.isSetSkuId()) {
        optionals.set(4);
      }
      if (struct.isSetPrice()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetDescription()) {
        oprot.writeString(struct.description);
      }
      if (struct.isSetTid()) {
        oprot.writeString(struct.tid);
      }
      if (struct.isSetItemId()) {
        oprot.writeI64(struct.itemId);
      }
      if (struct.isSetProductId()) {
        oprot.writeI64(struct.productId);
      }
      if (struct.isSetSkuId()) {
        oprot.writeI64(struct.skuId);
      }
      if (struct.isSetPrice()) {
        oprot.writeDouble(struct.price);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ThriftCartItemResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.code = iprot.readI32();
      struct.setCodeIsSet(true);
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.description = iprot.readString();
        struct.setDescriptionIsSet(true);
      }
      if (incoming.get(1)) {
        struct.tid = iprot.readString();
        struct.setTidIsSet(true);
      }
      if (incoming.get(2)) {
        struct.itemId = iprot.readI64();
        struct.setItemIdIsSet(true);
      }
      if (incoming.get(3)) {
        struct.productId = iprot.readI64();
        struct.setProductIdIsSet(true);
      }
      if (incoming.get(4)) {
        struct.skuId = iprot.readI64();
        struct.setSkuIdIsSet(true);
      }
      if (incoming.get(5)) {
        struct.price = iprot.readDouble();
        struct.setPriceIsSet(true);
      }
    }
  }

}

