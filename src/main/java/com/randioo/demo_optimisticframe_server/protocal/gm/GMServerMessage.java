// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GMServerMessage.proto

package com.randioo.demo_optimisticframe_server.protocal.gm;

public final class GMServerMessage {
  private GMServerMessage() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public static final class GMSCMessage extends
      com.google.protobuf.GeneratedMessage {
    // Use GMSCMessage.newBuilder() to construct.
    private GMSCMessage() {
      initFields();
    }
    private GMSCMessage(boolean noInit) {}
    
    private static final GMSCMessage defaultInstance;
    public static GMSCMessage getDefaultInstance() {
      return defaultInstance;
    }
    
    public GMSCMessage getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.internal_static_com_randioo_demo_optimisticframe_server_protocal_gm_GMSCMessage_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.internal_static_com_randioo_demo_optimisticframe_server_protocal_gm_GMSCMessage_fieldAccessorTable;
    }
    
    // optional .com.randioo.demo_optimisticframe_server.protocal.gm.GmRejectLoginResponse gmRejectLoginResponse = 1;
    public static final int GMREJECTLOGINRESPONSE_FIELD_NUMBER = 1;
    private boolean hasGmRejectLoginResponse;
    private com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmRejectLoginResponse gmRejectLoginResponse_;
    public boolean hasGmRejectLoginResponse() { return hasGmRejectLoginResponse; }
    public com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmRejectLoginResponse getGmRejectLoginResponse() { return gmRejectLoginResponse_; }
    
    // optional .com.randioo.demo_optimisticframe_server.protocal.gm.GmOpenLoginResponse gmOpenLoginResponse = 2;
    public static final int GMOPENLOGINRESPONSE_FIELD_NUMBER = 2;
    private boolean hasGmOpenLoginResponse;
    private com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmOpenLoginResponse gmOpenLoginResponse_;
    public boolean hasGmOpenLoginResponse() { return hasGmOpenLoginResponse; }
    public com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmOpenLoginResponse getGmOpenLoginResponse() { return gmOpenLoginResponse_; }
    
    // optional .com.randioo.demo_optimisticframe_server.protocal.gm.GmShutdownServerResponse gmShutdownServerResponse = 3;
    public static final int GMSHUTDOWNSERVERRESPONSE_FIELD_NUMBER = 3;
    private boolean hasGmShutdownServerResponse;
    private com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmShutdownServerResponse gmShutdownServerResponse_;
    public boolean hasGmShutdownServerResponse() { return hasGmShutdownServerResponse; }
    public com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmShutdownServerResponse getGmShutdownServerResponse() { return gmShutdownServerResponse_; }
    
    private void initFields() {
      gmRejectLoginResponse_ = com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmRejectLoginResponse.getDefaultInstance();
      gmOpenLoginResponse_ = com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmOpenLoginResponse.getDefaultInstance();
      gmShutdownServerResponse_ = com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmShutdownServerResponse.getDefaultInstance();
    }
    public final boolean isInitialized() {
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasGmRejectLoginResponse()) {
        output.writeMessage(1, getGmRejectLoginResponse());
      }
      if (hasGmOpenLoginResponse()) {
        output.writeMessage(2, getGmOpenLoginResponse());
      }
      if (hasGmShutdownServerResponse()) {
        output.writeMessage(3, getGmShutdownServerResponse());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasGmRejectLoginResponse()) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, getGmRejectLoginResponse());
      }
      if (hasGmOpenLoginResponse()) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, getGmOpenLoginResponse());
      }
      if (hasGmShutdownServerResponse()) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, getGmShutdownServerResponse());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage parseDelimitedFrom(
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
    public static com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage result;
      
      // Construct using com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage();
        return builder;
      }
      
      protected com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage.getDescriptor();
      }
      
      public com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage getDefaultInstanceForType() {
        return com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage) {
          return mergeFrom((com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage other) {
        if (other == com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage.getDefaultInstance()) return this;
        if (other.hasGmRejectLoginResponse()) {
          mergeGmRejectLoginResponse(other.getGmRejectLoginResponse());
        }
        if (other.hasGmOpenLoginResponse()) {
          mergeGmOpenLoginResponse(other.getGmOpenLoginResponse());
        }
        if (other.hasGmShutdownServerResponse()) {
          mergeGmShutdownServerResponse(other.getGmShutdownServerResponse());
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
            case 10: {
              com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmRejectLoginResponse.Builder subBuilder = com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmRejectLoginResponse.newBuilder();
              if (hasGmRejectLoginResponse()) {
                subBuilder.mergeFrom(getGmRejectLoginResponse());
              }
              input.readMessage(subBuilder, extensionRegistry);
              setGmRejectLoginResponse(subBuilder.buildPartial());
              break;
            }
            case 18: {
              com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmOpenLoginResponse.Builder subBuilder = com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmOpenLoginResponse.newBuilder();
              if (hasGmOpenLoginResponse()) {
                subBuilder.mergeFrom(getGmOpenLoginResponse());
              }
              input.readMessage(subBuilder, extensionRegistry);
              setGmOpenLoginResponse(subBuilder.buildPartial());
              break;
            }
            case 26: {
              com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmShutdownServerResponse.Builder subBuilder = com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmShutdownServerResponse.newBuilder();
              if (hasGmShutdownServerResponse()) {
                subBuilder.mergeFrom(getGmShutdownServerResponse());
              }
              input.readMessage(subBuilder, extensionRegistry);
              setGmShutdownServerResponse(subBuilder.buildPartial());
              break;
            }
          }
        }
      }
      
      
      // optional .com.randioo.demo_optimisticframe_server.protocal.gm.GmRejectLoginResponse gmRejectLoginResponse = 1;
      public boolean hasGmRejectLoginResponse() {
        return result.hasGmRejectLoginResponse();
      }
      public com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmRejectLoginResponse getGmRejectLoginResponse() {
        return result.getGmRejectLoginResponse();
      }
      public Builder setGmRejectLoginResponse(com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmRejectLoginResponse value) {
        if (value == null) {
          throw new NullPointerException();
        }
        result.hasGmRejectLoginResponse = true;
        result.gmRejectLoginResponse_ = value;
        return this;
      }
      public Builder setGmRejectLoginResponse(com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmRejectLoginResponse.Builder builderForValue) {
        result.hasGmRejectLoginResponse = true;
        result.gmRejectLoginResponse_ = builderForValue.build();
        return this;
      }
      public Builder mergeGmRejectLoginResponse(com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmRejectLoginResponse value) {
        if (result.hasGmRejectLoginResponse() &&
            result.gmRejectLoginResponse_ != com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmRejectLoginResponse.getDefaultInstance()) {
          result.gmRejectLoginResponse_ =
            com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmRejectLoginResponse.newBuilder(result.gmRejectLoginResponse_).mergeFrom(value).buildPartial();
        } else {
          result.gmRejectLoginResponse_ = value;
        }
        result.hasGmRejectLoginResponse = true;
        return this;
      }
      public Builder clearGmRejectLoginResponse() {
        result.hasGmRejectLoginResponse = false;
        result.gmRejectLoginResponse_ = com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmRejectLoginResponse.getDefaultInstance();
        return this;
      }
      
      // optional .com.randioo.demo_optimisticframe_server.protocal.gm.GmOpenLoginResponse gmOpenLoginResponse = 2;
      public boolean hasGmOpenLoginResponse() {
        return result.hasGmOpenLoginResponse();
      }
      public com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmOpenLoginResponse getGmOpenLoginResponse() {
        return result.getGmOpenLoginResponse();
      }
      public Builder setGmOpenLoginResponse(com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmOpenLoginResponse value) {
        if (value == null) {
          throw new NullPointerException();
        }
        result.hasGmOpenLoginResponse = true;
        result.gmOpenLoginResponse_ = value;
        return this;
      }
      public Builder setGmOpenLoginResponse(com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmOpenLoginResponse.Builder builderForValue) {
        result.hasGmOpenLoginResponse = true;
        result.gmOpenLoginResponse_ = builderForValue.build();
        return this;
      }
      public Builder mergeGmOpenLoginResponse(com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmOpenLoginResponse value) {
        if (result.hasGmOpenLoginResponse() &&
            result.gmOpenLoginResponse_ != com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmOpenLoginResponse.getDefaultInstance()) {
          result.gmOpenLoginResponse_ =
            com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmOpenLoginResponse.newBuilder(result.gmOpenLoginResponse_).mergeFrom(value).buildPartial();
        } else {
          result.gmOpenLoginResponse_ = value;
        }
        result.hasGmOpenLoginResponse = true;
        return this;
      }
      public Builder clearGmOpenLoginResponse() {
        result.hasGmOpenLoginResponse = false;
        result.gmOpenLoginResponse_ = com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmOpenLoginResponse.getDefaultInstance();
        return this;
      }
      
      // optional .com.randioo.demo_optimisticframe_server.protocal.gm.GmShutdownServerResponse gmShutdownServerResponse = 3;
      public boolean hasGmShutdownServerResponse() {
        return result.hasGmShutdownServerResponse();
      }
      public com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmShutdownServerResponse getGmShutdownServerResponse() {
        return result.getGmShutdownServerResponse();
      }
      public Builder setGmShutdownServerResponse(com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmShutdownServerResponse value) {
        if (value == null) {
          throw new NullPointerException();
        }
        result.hasGmShutdownServerResponse = true;
        result.gmShutdownServerResponse_ = value;
        return this;
      }
      public Builder setGmShutdownServerResponse(com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmShutdownServerResponse.Builder builderForValue) {
        result.hasGmShutdownServerResponse = true;
        result.gmShutdownServerResponse_ = builderForValue.build();
        return this;
      }
      public Builder mergeGmShutdownServerResponse(com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmShutdownServerResponse value) {
        if (result.hasGmShutdownServerResponse() &&
            result.gmShutdownServerResponse_ != com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmShutdownServerResponse.getDefaultInstance()) {
          result.gmShutdownServerResponse_ =
            com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmShutdownServerResponse.newBuilder(result.gmShutdownServerResponse_).mergeFrom(value).buildPartial();
        } else {
          result.gmShutdownServerResponse_ = value;
        }
        result.hasGmShutdownServerResponse = true;
        return this;
      }
      public Builder clearGmShutdownServerResponse() {
        result.hasGmShutdownServerResponse = false;
        result.gmShutdownServerResponse_ = com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmShutdownServerResponse.getDefaultInstance();
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:com.randioo.demo_optimisticframe_server.protocal.gm.GMSCMessage)
    }
    
    static {
      defaultInstance = new GMSCMessage(true);
      com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:com.randioo.demo_optimisticframe_server.protocal.gm.GMSCMessage)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_randioo_demo_optimisticframe_server_protocal_gm_GMSCMessage_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_randioo_demo_optimisticframe_server_protocal_gm_GMSCMessage_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025GMServerMessage.proto\0223com.randioo.dem" +
      "o_optimisticframe_server.protocal.gm\032\010GM" +
      ".proto\"\320\002\n\013GMSCMessage\022i\n\025gmRejectLoginR" +
      "esponse\030\001 \001(\0132J.com.randioo.demo_optimis" +
      "ticframe_server.protocal.gm.GmRejectLogi" +
      "nResponse\022e\n\023gmOpenLoginResponse\030\002 \001(\0132H" +
      ".com.randioo.demo_optimisticframe_server" +
      ".protocal.gm.GmOpenLoginResponse\022o\n\030gmSh" +
      "utdownServerResponse\030\003 \001(\0132M.com.randioo" +
      ".demo_optimisticframe_server.protocal.gm",
      ".GmShutdownServerResponse"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_com_randioo_demo_optimisticframe_server_protocal_gm_GMSCMessage_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_com_randioo_demo_optimisticframe_server_protocal_gm_GMSCMessage_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_randioo_demo_optimisticframe_server_protocal_gm_GMSCMessage_descriptor,
              new java.lang.String[] { "GmRejectLoginResponse", "GmOpenLoginResponse", "GmShutdownServerResponse", },
              com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage.class,
              com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.randioo.demo_optimisticframe_server.protocal.gm.GM.getDescriptor(),
        }, assigner);
  }
  
  public static void internalForceInit() {}
  
  // @@protoc_insertion_point(outer_class_scope)
}