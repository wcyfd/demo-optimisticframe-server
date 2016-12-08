// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Match.proto

package com.randioo.demo_optimisticframe_server.protocal;

public final class Match {
  private Match() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public static final class MatchRoleRequest extends
      com.google.protobuf.GeneratedMessage {
    // Use MatchRoleRequest.newBuilder() to construct.
    private MatchRoleRequest() {
      initFields();
    }
    private MatchRoleRequest(boolean noInit) {}
    
    private static final MatchRoleRequest defaultInstance;
    public static MatchRoleRequest getDefaultInstance() {
      return defaultInstance;
    }
    
    public MatchRoleRequest getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.randioo.demo_optimisticframe_server.protocal.Match.internal_static_com_randioo_demo_optimisticframe_server_protocal_MatchRoleRequest_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.randioo.demo_optimisticframe_server.protocal.Match.internal_static_com_randioo_demo_optimisticframe_server_protocal_MatchRoleRequest_fieldAccessorTable;
    }
    
    // optional bool test = 1;
    public static final int TEST_FIELD_NUMBER = 1;
    private boolean hasTest;
    private boolean test_ = false;
    public boolean hasTest() { return hasTest; }
    public boolean getTest() { return test_; }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasTest()) {
        output.writeBool(1, getTest());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasTest()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(1, getTest());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest parseDelimitedFrom(
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
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest result;
      
      // Construct using com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest();
        return builder;
      }
      
      protected com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest.getDescriptor();
      }
      
      public com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest getDefaultInstanceForType() {
        return com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest) {
          return mergeFrom((com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest other) {
        if (other == com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest.getDefaultInstance()) return this;
        if (other.hasTest()) {
          setTest(other.getTest());
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
              setTest(input.readBool());
              break;
            }
          }
        }
      }
      
      
      // optional bool test = 1;
      public boolean hasTest() {
        return result.hasTest();
      }
      public boolean getTest() {
        return result.getTest();
      }
      public Builder setTest(boolean value) {
        result.hasTest = true;
        result.test_ = value;
        return this;
      }
      public Builder clearTest() {
        result.hasTest = false;
        result.test_ = false;
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:com.randioo.demo_optimisticframe_server.protocal.MatchRoleRequest)
    }
    
    static {
      defaultInstance = new MatchRoleRequest(true);
      com.randioo.demo_optimisticframe_server.protocal.Match.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:com.randioo.demo_optimisticframe_server.protocal.MatchRoleRequest)
  }
  
  public static final class MatchRoleResponse extends
      com.google.protobuf.GeneratedMessage {
    // Use MatchRoleResponse.newBuilder() to construct.
    private MatchRoleResponse() {
      initFields();
    }
    private MatchRoleResponse(boolean noInit) {}
    
    private static final MatchRoleResponse defaultInstance;
    public static MatchRoleResponse getDefaultInstance() {
      return defaultInstance;
    }
    
    public MatchRoleResponse getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.randioo.demo_optimisticframe_server.protocal.Match.internal_static_com_randioo_demo_optimisticframe_server_protocal_MatchRoleResponse_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.randioo.demo_optimisticframe_server.protocal.Match.internal_static_com_randioo_demo_optimisticframe_server_protocal_MatchRoleResponse_fieldAccessorTable;
    }
    
    // optional int32 errorCode = 1;
    public static final int ERRORCODE_FIELD_NUMBER = 1;
    private boolean hasErrorCode;
    private int errorCode_ = 0;
    public boolean hasErrorCode() { return hasErrorCode; }
    public int getErrorCode() { return errorCode_; }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasErrorCode()) {
        output.writeInt32(1, getErrorCode());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasErrorCode()) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, getErrorCode());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse parseDelimitedFrom(
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
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse result;
      
      // Construct using com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse();
        return builder;
      }
      
      protected com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse.getDescriptor();
      }
      
      public com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse getDefaultInstanceForType() {
        return com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse) {
          return mergeFrom((com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse other) {
        if (other == com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse.getDefaultInstance()) return this;
        if (other.hasErrorCode()) {
          setErrorCode(other.getErrorCode());
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
              setErrorCode(input.readInt32());
              break;
            }
          }
        }
      }
      
      
      // optional int32 errorCode = 1;
      public boolean hasErrorCode() {
        return result.hasErrorCode();
      }
      public int getErrorCode() {
        return result.getErrorCode();
      }
      public Builder setErrorCode(int value) {
        result.hasErrorCode = true;
        result.errorCode_ = value;
        return this;
      }
      public Builder clearErrorCode() {
        result.hasErrorCode = false;
        result.errorCode_ = 0;
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:com.randioo.demo_optimisticframe_server.protocal.MatchRoleResponse)
    }
    
    static {
      defaultInstance = new MatchRoleResponse(true);
      com.randioo.demo_optimisticframe_server.protocal.Match.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:com.randioo.demo_optimisticframe_server.protocal.MatchRoleResponse)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_randioo_demo_optimisticframe_server_protocal_MatchRoleRequest_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_randioo_demo_optimisticframe_server_protocal_MatchRoleRequest_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_randioo_demo_optimisticframe_server_protocal_MatchRoleResponse_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_randioo_demo_optimisticframe_server_protocal_MatchRoleResponse_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013Match.proto\0220com.randioo.demo_optimist" +
      "icframe_server.protocal\" \n\020MatchRoleRequ" +
      "est\022\014\n\004test\030\001 \001(\010\"&\n\021MatchRoleResponse\022\021" +
      "\n\terrorCode\030\001 \001(\005"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_com_randioo_demo_optimisticframe_server_protocal_MatchRoleRequest_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_com_randioo_demo_optimisticframe_server_protocal_MatchRoleRequest_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_randioo_demo_optimisticframe_server_protocal_MatchRoleRequest_descriptor,
              new java.lang.String[] { "Test", },
              com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest.class,
              com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest.Builder.class);
          internal_static_com_randioo_demo_optimisticframe_server_protocal_MatchRoleResponse_descriptor =
            getDescriptor().getMessageTypes().get(1);
          internal_static_com_randioo_demo_optimisticframe_server_protocal_MatchRoleResponse_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_randioo_demo_optimisticframe_server_protocal_MatchRoleResponse_descriptor,
              new java.lang.String[] { "ErrorCode", },
              com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse.class,
              com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse.Builder.class);
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