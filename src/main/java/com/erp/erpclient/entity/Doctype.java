package com.erp.erpclient.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data; // Use Lombok to auto-generate getters/setters

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore unknown fields in JSON
public class Doctype {
    // Core Metadata
    @JsonProperty("name")
    protected String name;

    @JsonProperty("creation")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    protected LocalDateTime creation;

    @JsonProperty("modified")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    protected LocalDateTime modified;

    @JsonProperty("modified_by")
    protected String modifiedBy;

    @JsonProperty("owner")
    protected String owner;

    @JsonProperty("docstatus")
    protected int docstatus;

    @JsonProperty("idx")
    protected int idx;

    @JsonProperty("doctype")
    protected String doctype;

    // Audit/Logging
    @JsonProperty("_user_tags")
    protected String userTags;

    @JsonProperty("_comments")
    protected String comments;

    @JsonProperty("_assign")
    protected String assign;

    @JsonProperty("_liked_by")
    protected String likedBy;

    // Workflow/Status
    @JsonProperty("workflow_state")
    protected String workflowState;

    @JsonProperty("_seen")
    protected String seen;

    @JsonProperty("is_local")
    protected int isLocal;

    // Parent-Child Relationships
    @JsonProperty("parent")
    protected String parent;

    @JsonProperty("parenttype")
    protected String parentType;

    @JsonProperty("parentfield")
    protected String parentField;
}