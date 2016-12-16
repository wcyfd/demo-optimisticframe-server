// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Market.proto

package com.randioo.demo_optimisticframe_server.protocal;

public final class Market {
  private Market() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public static final class MarketBuyPlaneRequest extends
      com.google.protobuf.GeneratedMessage {
    // Use MarketBuyPlaneRequest.newBuilder() to construct.
    private MarketBuyPlaneRequest() {
      initFields();
    }
    private MarketBuyPlaneRequest(boolean noInit) {}
    
    private static final MarketBuyPlaneRequest defaultInstance;
    public static MarketBuyPlaneRequest getDefaultInstance() {
      return defaultInstance;
    }
    
    public MarketBuyPlaneRequest getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.randioo.demo_optimisticframe_server.protocal.Market.internal_static_com_randioo_demo_optimisticframe_server_protocal_MarketBuyPlaneRequest_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.randioo.demo_optimisticframe_server.protocal.Market.internal_static_com_randioo_demo_optimisticframe_server_protocal_MarketBuyPlaneRequest_fieldAccessorTable;
    }
    
    // optional int32 planeId = 1;
    public static final int PLANEID_FIELD_NUMBER = 1;
    private boolean hasPlaneId;
    private int planeId_ = 0;
    public boolean hasPlaneId() { return hasPlaneId; }
    public int getPlaneId() { return planeId_; }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasPlaneId()) {
        output.writeInt32(1, getPlaneId());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasPlaneId()) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, getPlaneId());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest result;
      
      // Construct using com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest();
        return builder;
      }
      
      protected com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest.getDescriptor();
      }
      
      public com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest getDefaultInstanceForType() {
        return com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest) {
          return mergeFrom((com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest other) {
        if (other == com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest.getDefaultInstance()) return this;
        if (other.hasPlaneId()) {
          setPlaneId(other.getPlaneId());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
            case 8: {
              setPlaneId(input.readInt32());
              break;
            }
          }
        }
      }
      
      
      // optional int32 planeId = 1;
      public boolean hasPlaneId() {
        return result.hasPlaneId();
      }
      public int getPlaneId() {
        return result.getPlaneId();
      }
      public Builder setPlaneId(int value) {
        result.hasPlaneId = true;
        result.planeId_ = value;
        return this;
      }
      public Builder clearPlaneId() {
        result.hasPlaneId = false;
        result.planeId_ = 0;
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:com.randioo.demo_optimisticframe_server.protocal.MarketBuyPlaneRequest)
    }
    
    static {
      defaultInstance = new MarketBuyPlaneRequest(true);
      com.randioo.demo_optimisticframe_server.protocal.Market.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:com.randioo.demo_optimisticframe_server.protocal.MarketBuyPlaneRequest)
  }
  
  public static final class MarketBuyPlaneResponse extends
      com.google.protobuf.GeneratedMessage {
    // Use MarketBuyPlaneResponse.newBuilder() to construct.
    private MarketBuyPlaneResponse() {
      initFields();
    }
    private MarketBuyPlaneResponse(boolean noInit) {}
    
    private static final MarketBuyPlaneResponse defaultInstance;
    public static MarketBuyPlaneResponse getDefaultInstance() {
      return defaultInstance;
    }
    
    public MarketBuyPlaneResponse getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.randioo.demo_optimisticframe_server.protocal.Market.internal_static_com_randioo_demo_optimisticframe_server_protocal_MarketBuyPlaneResponse_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.randioo.demo_optimisticframe_server.protocal.Market.internal_static_com_randioo_demo_optimisticframe_server_protocal_MarketBuyPlaneResponse_fieldAccessorTable;
    }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse result;
      
      // Construct using com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse();
        return builder;
      }
      
      protected com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse.getDescriptor();
      }
      
      public com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse getDefaultInstanceForType() {
        return com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse) {
          return mergeFrom((com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse other) {
        if (other == com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse.getDefaultInstance()) return this;
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
          }
        }
      }
      
      
      // @@protoc_insertion_point(builder_scope:com.randioo.demo_optimisticframe_server.protocal.MarketBuyPlaneResponse)
    }
    
    static {
      defaultInstance = new MarketBuyPlaneResponse(true);
      com.randioo.demo_optimisticframe_server.protocal.Market.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:com.randioo.demo_optimisticframe_server.protocal.MarketBuyPlaneResponse)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_randioo_demo_optimisticframe_server_protocal_MarketBuyPlaneRequest_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_randioo_demo_optimisticframe_server_protocal_MarketBuyPlaneRequest_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_randioo_demo_optimisticframe_server_protocal_MarketBuyPlaneResponse_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_randioo_demo_optimisticframe_server_protocal_MarketBuyPlaneResponse_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014Market.proto\0220com.randioo.demo_optimis" +
      "ticframe_server.protocal\"(\n\025MarketBuyPla" +
      "neRequest\022\017\n\007planeId\030\001 \001(\005\"\030\n\026MarketBuyP" +
      "laneResponse"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_com_randioo_demo_optimisticframe_server_protocal_MarketBuyPlaneRequest_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_com_randioo_demo_optimisticframe_server_protocal_MarketBuyPlaneRequest_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_randioo_demo_optimisticframe_server_protocal_MarketBuyPlaneRequest_descriptor,
              new java.lang.String[] { "PlaneId", },
              com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest.class,
              com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest.Builder.class);
          internal_static_com_randioo_demo_optimisticframe_server_protocal_MarketBuyPlaneResponse_descriptor =
            getDescriptor().getMessageTypes().get(1);
          internal_static_com_randioo_demo_optimisticframe_server_protocal_MarketBuyPlaneResponse_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_randioo_demo_optimisticframe_server_protocal_MarketBuyPlaneResponse_descriptor,
              new java.lang.String[] { },
              com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse.class,
              com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  public static void internalForceInit() {}
  
  // @@protoc_insertion_point(outer_class_scope)
}