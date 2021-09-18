package com.manappuram.twowheeler.response.Output;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GetScoreOutput implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("apiStatus")
    @Expose
    private String apiStatus;
    @SerializedName("responseMsg")
    @Expose
    private String responseMsg;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("errorList")
    @Expose
    private List<ErrorList_> errorList = null;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(String apiStatus) {
        this.apiStatus = apiStatus;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<ErrorList_> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<ErrorList_> errorList) {
        this.errorList = errorList;
    }

    public class Data implements Serializable {

        @SerializedName("response")
        @Expose
        private String response;
        @SerializedName("body")
        @Expose
        private Body body;
        @SerializedName("cibilApplicationNoResponse")
        @Expose
        private CibilApplicationNoResponse cibilApplicationNoResponse;

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }

        public Body getBody() {
            return body;
        }

        public void setBody(Body body) {
            this.body = body;
        }

        public CibilApplicationNoResponse getCibilApplicationNoResponse() {
            return cibilApplicationNoResponse;
        }

        public void setCibilApplicationNoResponse(CibilApplicationNoResponse cibilApplicationNoResponse) {
            this.cibilApplicationNoResponse = cibilApplicationNoResponse;
        }

    }

    public class Data_ implements Serializable {

        @SerializedName("envelope")
        @Expose
        private Envelope envelope;

        public Envelope getEnvelope() {
            return envelope;
        }

        public void setEnvelope(Envelope envelope) {
            this.envelope = envelope;
        }

    }

    public class ErrorList implements Serializable {

        @SerializedName("errorCode")
        @Expose
        private String errorCode;
        @SerializedName("errorMessage")
        @Expose
        private String errorMessage;
        @SerializedName("errorType")
        @Expose
        private String errorType;

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorType() {
            return errorType;
        }

        public void setErrorType(String errorType) {
            this.errorType = errorType;
        }

    }

    public class ErrorList_ implements Serializable {

        @SerializedName("errorCode")
        @Expose
        private String errorCode;
        @SerializedName("errorMessage")
        @Expose
        private String errorMessage;
        @SerializedName("errorType")
        @Expose
        private String errorType;

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorType() {
            return errorType;
        }

        public void setErrorType(String errorType) {
            this.errorType = errorType;
        }

    }

    public class Body implements Serializable {

        @SerializedName("downloadDocumentResponse")
        @Expose
        private DownloadDocumentResponse downloadDocumentResponse;

        public DownloadDocumentResponse getDownloadDocumentResponse() {
            return downloadDocumentResponse;
        }

        public void setDownloadDocumentResponse(DownloadDocumentResponse downloadDocumentResponse) {
            this.downloadDocumentResponse = downloadDocumentResponse;
        }

    }

    public class DownloadDocumentResponse implements Serializable {

        @SerializedName("xmlns")
        @Expose
        private String xmlns;
        @SerializedName("downloadDocumentResult")
        @Expose
        private DownloadDocumentResult downloadDocumentResult;

        public String getXmlns() {
            return xmlns;
        }

        public void setXmlns(String xmlns) {
            this.xmlns = xmlns;
        }

        public DownloadDocumentResult getDownloadDocumentResult() {
            return downloadDocumentResult;
        }

        public void setDownloadDocumentResult(DownloadDocumentResult downloadDocumentResult) {
            this.downloadDocumentResult = downloadDocumentResult;
        }

    }

    public class DownloadDocumentResult implements Serializable {

        @SerializedName("xmlnsa")
        @Expose
        private String xmlnsa;
        @SerializedName("xmlnsi")
        @Expose
        private String xmlnsi;
        @SerializedName("fileContents")
        @Expose
        private List<String> fileContents = null;
        @SerializedName("fileContent")
        @Expose
        private String fileContent;
        @SerializedName("aResponse")
        @Expose
        private AResponse aResponse;

        public String getXmlnsa() {
            return xmlnsa;
        }

        public void setXmlnsa(String xmlnsa) {
            this.xmlnsa = xmlnsa;
        }

        public String getXmlnsi() {
            return xmlnsi;
        }

        public void setXmlnsi(String xmlnsi) {
            this.xmlnsi = xmlnsi;
        }

        public List<String> getFileContents() {
            return fileContents;
        }

        public void setFileContents(List<String> fileContents) {
            this.fileContents = fileContents;
        }

        public String getFileContent() {
            return fileContent;
        }

        public void setFileContent(String fileContent) {
            this.fileContent = fileContent;
        }

        public AResponse getAResponse() {
            return aResponse;
        }

        public void setAResponse(AResponse aResponse) {
            this.aResponse = aResponse;
        }

    }

    public class AResponse implements Serializable {

        @SerializedName("dcResponse")
        @Expose
        private DcResponse dcResponse;

        public DcResponse getDcResponse() {
            return dcResponse;
        }

        public void setDcResponse(DcResponse dcResponse) {
            this.dcResponse = dcResponse;
        }

    }

    public class DcResponse implements Serializable {

        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("authentication")
        @Expose
        private Authentication authentication;
        @SerializedName("responseInfo")
        @Expose
        private ResponseInfo responseInfo;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Authentication getAuthentication() {
            return authentication;
        }

        public void setAuthentication(Authentication authentication) {
            this.authentication = authentication;
        }

        public ResponseInfo getResponseInfo() {
            return responseInfo;
        }

        public void setResponseInfo(ResponseInfo responseInfo) {
            this.responseInfo = responseInfo;
        }

    }

    public class Authentication implements Serializable {

        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("token")
        @Expose
        private String token;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

    }

    public class ResponseInfo implements Serializable {


    }

    public class CibilApplicationNoResponse implements Serializable {

        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("apiStatus")
        @Expose
        private String apiStatus;
        @SerializedName("responseMsg")
        @Expose
        private String responseMsg;
        @SerializedName("data")
        @Expose
        private Data_ data;
        @SerializedName("errorList")
        @Expose
        private List<ErrorList> errorList = null;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getApiStatus() {
            return apiStatus;
        }

        public void setApiStatus(String apiStatus) {
            this.apiStatus = apiStatus;
        }

        public String getResponseMsg() {
            return responseMsg;
        }

        public void setResponseMsg(String responseMsg) {
            this.responseMsg = responseMsg;
        }

        public Data_ getData() {
            return data;
        }

        public void setData(Data_ data) {
            this.data = data;
        }

        public List<ErrorList> getErrorList() {
            return errorList;
        }

        public void setErrorList(List<ErrorList> errorList) {
            this.errorList = errorList;
        }

    }

    public class Envelope implements Serializable {

        @SerializedName("xmlnss")
        @Expose
        private String xmlnss;
        @SerializedName("body")
        @Expose
        private Body_ body;

        public String getXmlnss() {
            return xmlnss;
        }

        public void setXmlnss(String xmlnss) {
            this.xmlnss = xmlnss;
        }

        public Body_ getBody() {
            return body;
        }

        public void setBody(Body_ body) {
            this.body = body;
        }

    }

    public class Body_ implements Serializable {

        @SerializedName("executeXMLStringResponse")
        @Expose
        private ExecuteXMLStringResponse executeXMLStringResponse;

        public ExecuteXMLStringResponse getExecuteXMLStringResponse() {
            return executeXMLStringResponse;
        }

        public void setExecuteXMLStringResponse(ExecuteXMLStringResponse executeXMLStringResponse) {
            this.executeXMLStringResponse = executeXMLStringResponse;
        }

    }

    public class ExecuteXMLStringResponse implements Serializable {

        @SerializedName("xmlns")
        @Expose
        private String xmlns;
        @SerializedName("executeXMLStringResult")
        @Expose
        private ExecuteXMLStringResult executeXMLStringResult;

        public String getXmlns() {
            return xmlns;
        }

        public void setXmlns(String xmlns) {
            this.xmlns = xmlns;
        }

        public ExecuteXMLStringResult getExecuteXMLStringResult() {
            return executeXMLStringResult;
        }

        public void setExecuteXMLStringResult(ExecuteXMLStringResult executeXMLStringResult) {
            this.executeXMLStringResult = executeXMLStringResult;
        }

    }

    public class ExecuteXMLStringResult implements Serializable {

        @SerializedName("dcResponse")
        @Expose
        private DcResponse_ dcResponse;

        public DcResponse_ getDcResponse() {
            return dcResponse;
        }

        public void setDcResponse(DcResponse_ dcResponse) {
            this.dcResponse = dcResponse;
        }

    }

    public class DcResponse_ implements Serializable {

        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("authentication")
        @Expose
        private Authentication_ authentication;
        @SerializedName("responseInfo")
        @Expose
        private ResponseInfo_ responseInfo;
        @SerializedName("contextData")
        @Expose
        private ContextData contextData;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Authentication_ getAuthentication() {
            return authentication;
        }

        public void setAuthentication(Authentication_ authentication) {
            this.authentication = authentication;
        }

        public ResponseInfo_ getResponseInfo() {
            return responseInfo;
        }

        public void setResponseInfo(ResponseInfo_ responseInfo) {
            this.responseInfo = responseInfo;
        }

        public ContextData getContextData() {
            return contextData;
        }

        public void setContextData(ContextData contextData) {
            this.contextData = contextData;
        }

    }

    public class Authentication_ implements Serializable {


    }

    public class ResponseInfo_ implements Serializable {

        @SerializedName("applicationId")
        @Expose
        private String applicationId;
        @SerializedName("solutionSetInstanceId")
        @Expose
        private String solutionSetInstanceId;
        @SerializedName("currentQueue")
        @Expose
        private String currentQueue;

        public String getApplicationId() {
            return applicationId;
        }

        public void setApplicationId(String applicationId) {
            this.applicationId = applicationId;
        }

        public String getSolutionSetInstanceId() {
            return solutionSetInstanceId;
        }

        public void setSolutionSetInstanceId(String solutionSetInstanceId) {
            this.solutionSetInstanceId = solutionSetInstanceId;
        }

        public String getCurrentQueue() {
            return currentQueue;
        }

        public void setCurrentQueue(String currentQueue) {
            this.currentQueue = currentQueue;
        }

    }

    public class ContextData implements Serializable {

        @SerializedName("field")
        @Expose
        private List<Field> field = null;

        public List<Field> getField() {
            return field;
        }

        public void setField(List<Field> field) {
            this.field = field;
        }

    }

    public class Field implements Serializable {

        @SerializedName("key")
        @Expose
        private String key;
        @SerializedName("applicants")
        @Expose
        private Applicants applicants;
        @SerializedName("applicationData")
        @Expose
        private ApplicationData applicationData;
        @SerializedName("text")
        @Expose
        private String text;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Applicants getApplicants() {
            return applicants;
        }

        public void setApplicants(Applicants applicants) {
            this.applicants = applicants;
        }

        public ApplicationData getApplicationData() {
            return applicationData;
        }

        public void setApplicationData(ApplicationData applicationData) {
            this.applicationData = applicationData;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

    }

    public static class Applicants implements Serializable {

        @SerializedName("applicant")
        @Expose
        private Applicant applicant;

        public Applicant getApplicant() {
            return applicant;
        }

        public void setApplicant(Applicant applicant) {
            this.applicant = applicant;
        }

    }

    public class ApplicationData implements Serializable {

        @SerializedName("formattedReport")
        @Expose
        private String formattedReport;
        @SerializedName("mfiBranchReferenceNo")
        @Expose
        private String mfiBranchReferenceNo;
        @SerializedName("mfiCenterReferenceNo")
        @Expose
        private String mfiCenterReferenceNo;
        @SerializedName("mfiLoanPurpose")
        @Expose
        private String mfiLoanPurpose;
        @SerializedName("mfiEnquiryAmount")
        @Expose
        private String mfiEnquiryAmount;
        @SerializedName("consumerConsentForUIDAIAuthentication")
        @Expose
        private String consumerConsentForUIDAIAuthentication;
        @SerializedName("ntcProductType")
        @Expose
        private String ntcProductType;
        @SerializedName("mfiBureauFlag")
        @Expose
        private String mfiBureauFlag;
        @SerializedName("idVerificationFlag")
        @Expose
        private String idVerificationFlag;
        @SerializedName("dsTuNtcFlag")
        @Expose
        private String dsTuNtcFlag;
        @SerializedName("cibilBureauFlag")
        @Expose
        private String cibilBureauFlag;
        @SerializedName("password")
        @Expose
        private String password;
        @SerializedName("memberCode")
        @Expose
        private String memberCode;
        @SerializedName("gstStateCode")
        @Expose
        private String gstStateCode;
        @SerializedName("scoreType")
        @Expose
        private String scoreType;
        @SerializedName("amount")
        @Expose
        private String amount;
        @SerializedName("purpose")
        @Expose
        private String purpose;
        @SerializedName("mfiDocRequest")
        @Expose
        private String mfiDocRequest;
        @SerializedName("returnMessage")
        @Expose
        private String returnMessage;
        @SerializedName("dtTrail")
        @Expose
        private DtTrail dtTrail;
        @SerializedName("milestone")
        @Expose
        private Milestone milestone;
        @SerializedName("start")
        @Expose
        private String start;
        @SerializedName("inputValReasonCodes")
        @Expose
        private String inputValReasonCodes;
        @SerializedName("user")
        @Expose
        private String user;
        @SerializedName("businessUnitId")
        @Expose
        private String businessUnitId;
        @SerializedName("applicationId")
        @Expose
        private String applicationId;
        @SerializedName("solutionSetId")
        @Expose
        private String solutionSetId;
        @SerializedName("environmentTypeId")
        @Expose
        private String environmentTypeId;
        @SerializedName("environmentType")
        @Expose
        private String environmentType;

        public String getFormattedReport() {
            return formattedReport;
        }

        public void setFormattedReport(String formattedReport) {
            this.formattedReport = formattedReport;
        }

        public String getMfiBranchReferenceNo() {
            return mfiBranchReferenceNo;
        }

        public void setMfiBranchReferenceNo(String mfiBranchReferenceNo) {
            this.mfiBranchReferenceNo = mfiBranchReferenceNo;
        }

        public String getMfiCenterReferenceNo() {
            return mfiCenterReferenceNo;
        }

        public void setMfiCenterReferenceNo(String mfiCenterReferenceNo) {
            this.mfiCenterReferenceNo = mfiCenterReferenceNo;
        }

        public String getMfiLoanPurpose() {
            return mfiLoanPurpose;
        }

        public void setMfiLoanPurpose(String mfiLoanPurpose) {
            this.mfiLoanPurpose = mfiLoanPurpose;
        }

        public String getMfiEnquiryAmount() {
            return mfiEnquiryAmount;
        }

        public void setMfiEnquiryAmount(String mfiEnquiryAmount) {
            this.mfiEnquiryAmount = mfiEnquiryAmount;
        }

        public String getConsumerConsentForUIDAIAuthentication() {
            return consumerConsentForUIDAIAuthentication;
        }

        public void setConsumerConsentForUIDAIAuthentication(String consumerConsentForUIDAIAuthentication) {
            this.consumerConsentForUIDAIAuthentication = consumerConsentForUIDAIAuthentication;
        }

        public String getNtcProductType() {
            return ntcProductType;
        }

        public void setNtcProductType(String ntcProductType) {
            this.ntcProductType = ntcProductType;
        }

        public String getMfiBureauFlag() {
            return mfiBureauFlag;
        }

        public void setMfiBureauFlag(String mfiBureauFlag) {
            this.mfiBureauFlag = mfiBureauFlag;
        }

        public String getIdVerificationFlag() {
            return idVerificationFlag;
        }

        public void setIdVerificationFlag(String idVerificationFlag) {
            this.idVerificationFlag = idVerificationFlag;
        }

        public String getDsTuNtcFlag() {
            return dsTuNtcFlag;
        }

        public void setDsTuNtcFlag(String dsTuNtcFlag) {
            this.dsTuNtcFlag = dsTuNtcFlag;
        }

        public String getCibilBureauFlag() {
            return cibilBureauFlag;
        }

        public void setCibilBureauFlag(String cibilBureauFlag) {
            this.cibilBureauFlag = cibilBureauFlag;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getMemberCode() {
            return memberCode;
        }

        public void setMemberCode(String memberCode) {
            this.memberCode = memberCode;
        }

        public String getGstStateCode() {
            return gstStateCode;
        }

        public void setGstStateCode(String gstStateCode) {
            this.gstStateCode = gstStateCode;
        }

        public String getScoreType() {
            return scoreType;
        }

        public void setScoreType(String scoreType) {
            this.scoreType = scoreType;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getPurpose() {
            return purpose;
        }

        public void setPurpose(String purpose) {
            this.purpose = purpose;
        }

        public String getMfiDocRequest() {
            return mfiDocRequest;
        }

        public void setMfiDocRequest(String mfiDocRequest) {
            this.mfiDocRequest = mfiDocRequest;
        }

        public String getReturnMessage() {
            return returnMessage;
        }

        public void setReturnMessage(String returnMessage) {
            this.returnMessage = returnMessage;
        }

        public DtTrail getDtTrail() {
            return dtTrail;
        }

        public void setDtTrail(DtTrail dtTrail) {
            this.dtTrail = dtTrail;
        }

        public Milestone getMilestone() {
            return milestone;
        }

        public void setMilestone(Milestone milestone) {
            this.milestone = milestone;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getInputValReasonCodes() {
            return inputValReasonCodes;
        }

        public void setInputValReasonCodes(String inputValReasonCodes) {
            this.inputValReasonCodes = inputValReasonCodes;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getBusinessUnitId() {
            return businessUnitId;
        }

        public void setBusinessUnitId(String businessUnitId) {
            this.businessUnitId = businessUnitId;
        }

        public String getApplicationId() {
            return applicationId;
        }

        public void setApplicationId(String applicationId) {
            this.applicationId = applicationId;
        }

        public String getSolutionSetId() {
            return solutionSetId;
        }

        public void setSolutionSetId(String solutionSetId) {
            this.solutionSetId = solutionSetId;
        }

        public String getEnvironmentTypeId() {
            return environmentTypeId;
        }

        public void setEnvironmentTypeId(String environmentTypeId) {
            this.environmentTypeId = environmentTypeId;
        }

        public String getEnvironmentType() {
            return environmentType;
        }

        public void setEnvironmentType(String environmentType) {
            this.environmentType = environmentType;
        }

    }

    public class DtTrail implements Serializable {

        @SerializedName("step")
        @Expose
        private Step step;

        public Step getStep() {
            return step;
        }

        public void setStep(Step step) {
            this.step = step;
        }

    }

    public class Step implements Serializable {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("duration")
        @Expose
        private String duration;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

    }

    public class Milestone implements Serializable {

        @SerializedName("step")
        @Expose
        private String step;

        public String getStep() {
            return step;
        }

        public void setStep(String step) {
            this.step = step;
        }

    }

    public class Applicant implements Serializable {

        @SerializedName("nomineeRelation")
        @Expose
        private String nomineeRelation;
        @SerializedName("nomineeName")
        @Expose
        private String nomineeName;
        @SerializedName("memberRelationType4")
        @Expose
        private String memberRelationType4;
        @SerializedName("memberRelationName4")
        @Expose
        private String memberRelationName4;
        @SerializedName("memberRelationType3")
        @Expose
        private String memberRelationType3;
        @SerializedName("memberRelationName3")
        @Expose
        private String memberRelationName3;
        @SerializedName("memberRelationType2")
        @Expose
        private String memberRelationType2;
        @SerializedName("memberRelationName2")
        @Expose
        private String memberRelationName2;
        @SerializedName("memberRelationType1")
        @Expose
        private String memberRelationType1;
        @SerializedName("memberRelationName1")
        @Expose
        private String memberRelationName1;
        @SerializedName("keyPersonRelation")
        @Expose
        private String keyPersonRelation;
        @SerializedName("keyPersonName")
        @Expose
        private String keyPersonName;
        @SerializedName("memberOtherId3")
        @Expose
        private String memberOtherId3;
        @SerializedName("memberOtherId3Type")
        @Expose
        private String memberOtherId3Type;
        @SerializedName("memberOtherId2")
        @Expose
        private String memberOtherId2;
        @SerializedName("memberOtherId2Type")
        @Expose
        private String memberOtherId2Type;
        @SerializedName("memberOtherId1")
        @Expose
        private String memberOtherId1;
        @SerializedName("memberOtherId1Type")
        @Expose
        private String memberOtherId1Type;
        @SerializedName("addresses")
        @Expose
        private Addresses addresses;
        @SerializedName("telephones")
        @Expose
        private Telephones telephones;
        @SerializedName("identifiers")
        @Expose
        private Identifiers identifiers;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("dateOfBirth")
        @Expose
        private String dateOfBirth;
        @SerializedName("applicantLastName")
        @Expose
        private String applicantLastName;
        @SerializedName("applicantMiddleName")
        @Expose
        private String applicantMiddleName;
        @SerializedName("applicantFirstName")
        @Expose
        private String applicantFirstName;
        @SerializedName("applicantType")
        @Expose
        private String applicantType;
        @SerializedName("nodeIdentifier")
        @Expose
        private String nodeIdentifier;
        @SerializedName("dsCibilBureau")
        @Expose
        private DsCibilBureau dsCibilBureau;
        @SerializedName("dsAadharEkycOtp")
        @Expose
        private String dsAadharEkycOtp;
        @SerializedName("dsTuNtc")
        @Expose
        private DsTuNtc dsTuNtc;

        public String getNomineeRelation() {
            return nomineeRelation;
        }

        public void setNomineeRelation(String nomineeRelation) {
            this.nomineeRelation = nomineeRelation;
        }

        public String getNomineeName() {
            return nomineeName;
        }

        public void setNomineeName(String nomineeName) {
            this.nomineeName = nomineeName;
        }

        public String getMemberRelationType4() {
            return memberRelationType4;
        }

        public void setMemberRelationType4(String memberRelationType4) {
            this.memberRelationType4 = memberRelationType4;
        }

        public String getMemberRelationName4() {
            return memberRelationName4;
        }

        public void setMemberRelationName4(String memberRelationName4) {
            this.memberRelationName4 = memberRelationName4;
        }

        public String getMemberRelationType3() {
            return memberRelationType3;
        }

        public void setMemberRelationType3(String memberRelationType3) {
            this.memberRelationType3 = memberRelationType3;
        }

        public String getMemberRelationName3() {
            return memberRelationName3;
        }

        public void setMemberRelationName3(String memberRelationName3) {
            this.memberRelationName3 = memberRelationName3;
        }

        public String getMemberRelationType2() {
            return memberRelationType2;
        }

        public void setMemberRelationType2(String memberRelationType2) {
            this.memberRelationType2 = memberRelationType2;
        }

        public String getMemberRelationName2() {
            return memberRelationName2;
        }

        public void setMemberRelationName2(String memberRelationName2) {
            this.memberRelationName2 = memberRelationName2;
        }

        public String getMemberRelationType1() {
            return memberRelationType1;
        }

        public void setMemberRelationType1(String memberRelationType1) {
            this.memberRelationType1 = memberRelationType1;
        }

        public String getMemberRelationName1() {
            return memberRelationName1;
        }

        public void setMemberRelationName1(String memberRelationName1) {
            this.memberRelationName1 = memberRelationName1;
        }

        public String getKeyPersonRelation() {
            return keyPersonRelation;
        }

        public void setKeyPersonRelation(String keyPersonRelation) {
            this.keyPersonRelation = keyPersonRelation;
        }

        public String getKeyPersonName() {
            return keyPersonName;
        }

        public void setKeyPersonName(String keyPersonName) {
            this.keyPersonName = keyPersonName;
        }

        public String getMemberOtherId3() {
            return memberOtherId3;
        }

        public void setMemberOtherId3(String memberOtherId3) {
            this.memberOtherId3 = memberOtherId3;
        }

        public String getMemberOtherId3Type() {
            return memberOtherId3Type;
        }

        public void setMemberOtherId3Type(String memberOtherId3Type) {
            this.memberOtherId3Type = memberOtherId3Type;
        }

        public String getMemberOtherId2() {
            return memberOtherId2;
        }

        public void setMemberOtherId2(String memberOtherId2) {
            this.memberOtherId2 = memberOtherId2;
        }

        public String getMemberOtherId2Type() {
            return memberOtherId2Type;
        }

        public void setMemberOtherId2Type(String memberOtherId2Type) {
            this.memberOtherId2Type = memberOtherId2Type;
        }

        public String getMemberOtherId1() {
            return memberOtherId1;
        }

        public void setMemberOtherId1(String memberOtherId1) {
            this.memberOtherId1 = memberOtherId1;
        }

        public String getMemberOtherId1Type() {
            return memberOtherId1Type;
        }

        public void setMemberOtherId1Type(String memberOtherId1Type) {
            this.memberOtherId1Type = memberOtherId1Type;
        }

        public Addresses getAddresses() {
            return addresses;
        }

        public void setAddresses(Addresses addresses) {
            this.addresses = addresses;
        }

        public Telephones getTelephones() {
            return telephones;
        }

        public void setTelephones(Telephones telephones) {
            this.telephones = telephones;
        }

        public Identifiers getIdentifiers() {
            return identifiers;
        }

        public void setIdentifiers(Identifiers identifiers) {
            this.identifiers = identifiers;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getApplicantLastName() {
            return applicantLastName;
        }

        public void setApplicantLastName(String applicantLastName) {
            this.applicantLastName = applicantLastName;
        }

        public String getApplicantMiddleName() {
            return applicantMiddleName;
        }

        public void setApplicantMiddleName(String applicantMiddleName) {
            this.applicantMiddleName = applicantMiddleName;
        }

        public String getApplicantFirstName() {
            return applicantFirstName;
        }

        public void setApplicantFirstName(String applicantFirstName) {
            this.applicantFirstName = applicantFirstName;
        }

        public String getApplicantType() {
            return applicantType;
        }

        public void setApplicantType(String applicantType) {
            this.applicantType = applicantType;
        }

        public String getNodeIdentifier() {
            return nodeIdentifier;
        }

        public void setNodeIdentifier(String nodeIdentifier) {
            this.nodeIdentifier = nodeIdentifier;
        }

        public DsCibilBureau getDsCibilBureau() {
            return dsCibilBureau;
        }

        public void setDsCibilBureau(DsCibilBureau dsCibilBureau) {
            this.dsCibilBureau = dsCibilBureau;
        }

        public String getDsAadharEkycOtp() {
            return dsAadharEkycOtp;
        }

        public void setDsAadharEkycOtp(String dsAadharEkycOtp) {
            this.dsAadharEkycOtp = dsAadharEkycOtp;
        }

        public DsTuNtc getDsTuNtc() {
            return dsTuNtc;
        }

        public void setDsTuNtc(DsTuNtc dsTuNtc) {
            this.dsTuNtc = dsTuNtc;
        }

    }

    public class Addresses implements Serializable {

        @SerializedName("address")
        @Expose
        private Address address;

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

    }

    public class Identifiers implements Serializable {

        @SerializedName("identifier")
        @Expose
        private Identifier identifier;

        public Identifier getIdentifier() {
            return identifier;
        }

        public void setIdentifier(Identifier identifier) {
            this.identifier = identifier;
        }

    }

    public class Identifier implements Serializable {


    }

    public class Address implements Serializable {


    }

    public class Telephones implements Serializable {

        @SerializedName("telephone")
        @Expose
        private Telephone telephone;

        public Telephone getTelephone() {
            return telephone;
        }

        public void setTelephone(Telephone telephone) {
            this.telephone = telephone;
        }

    }

    public class Telephone implements Serializable {


    }

    public class DsCibilBureau implements Serializable {

        @SerializedName("dsCibilBureauData")
        @Expose
        private DsCibilBureauData dsCibilBureauData;
        @SerializedName("dsCibilBureauStatus")
        @Expose
        private DsCibilBureauStatus dsCibilBureauStatus;
        @SerializedName("response")
        @Expose
        private Response response;

        public DsCibilBureauData getDsCibilBureauData() {
            return dsCibilBureauData;
        }

        public void setDsCibilBureauData(DsCibilBureauData dsCibilBureauData) {
            this.dsCibilBureauData = dsCibilBureauData;
        }

        public DsCibilBureauStatus getDsCibilBureauStatus() {
            return dsCibilBureauStatus;
        }

        public void setDsCibilBureauStatus(DsCibilBureauStatus dsCibilBureauStatus) {
            this.dsCibilBureauStatus = dsCibilBureauStatus;
        }

        public Response getResponse() {
            return response;
        }

        public void setResponse(Response response) {
            this.response = response;
        }

    }

    public class DsCibilBureauData implements Serializable {

        @SerializedName("request")
        @Expose
        private Request request;

        public Request getRequest() {
            return request;
        }

        public void setRequest(Request request) {
            this.request = request;
        }

    }

    public class DsCibilBureauStatus implements Serializable {

        @SerializedName("trail")
        @Expose
        private String trail;

        public String getTrail() {
            return trail;
        }

        public void setTrail(String trail) {
            this.trail = trail;
        }

    }

    public class DsTuNtc implements Serializable {


    }

    public class Request implements Serializable {

        @SerializedName("consumerDetails")
        @Expose
        private ConsumerDetails consumerDetails;

        public ConsumerDetails getConsumerDetails() {
            return consumerDetails;
        }

        public void setConsumerDetails(ConsumerDetails consumerDetails) {
            this.consumerDetails = consumerDetails;
        }

    }

    public class ConsumerDetails implements Serializable {

        @SerializedName("creditReportInquiry")
        @Expose
        private CreditReportInquiry creditReportInquiry;

        public CreditReportInquiry getCreditReportInquiry() {
            return creditReportInquiry;
        }

        public void setCreditReportInquiry(CreditReportInquiry creditReportInquiry) {
            this.creditReportInquiry = creditReportInquiry;
        }

    }

    public class CreditReportInquiry implements Serializable {

        @SerializedName("header")
        @Expose
        private Header header;
        @SerializedName("names")
        @Expose
        private Names names;
        @SerializedName("identifications")
        @Expose
        private Identifications identifications;
        @SerializedName("telephones")
        @Expose
        private Telephones_ telephones;
        @SerializedName("addresses")
        @Expose
        private Addresses_ addresses;

        public Header getHeader() {
            return header;
        }

        public void setHeader(Header header) {
            this.header = header;
        }

        public Names getNames() {
            return names;
        }

        public void setNames(Names names) {
            this.names = names;
        }

        public Identifications getIdentifications() {
            return identifications;
        }

        public void setIdentifications(Identifications identifications) {
            this.identifications = identifications;
        }

        public Telephones_ getTelephones() {
            return telephones;
        }

        public void setTelephones(Telephones_ telephones) {
            this.telephones = telephones;
        }

        public Addresses_ getAddresses() {
            return addresses;
        }

        public void setAddresses(Addresses_ addresses) {
            this.addresses = addresses;
        }

    }

    public class Header implements Serializable {

        @SerializedName("segmentTag")
        @Expose
        private String segmentTag;
        @SerializedName("version")
        @Expose
        private String version;
        @SerializedName("referenceNumber")
        @Expose
        private String referenceNumber;
        @SerializedName("futureUse1")
        @Expose
        private String futureUse1;
        @SerializedName("memberCode")
        @Expose
        private String memberCode;
        @SerializedName("password")
        @Expose
        private String password;
        @SerializedName("purpose")
        @Expose
        private String purpose;
        @SerializedName("amount")
        @Expose
        private String amount;
        @SerializedName("futureUse2")
        @Expose
        private String futureUse2;
        @SerializedName("scoreType")
        @Expose
        private String scoreType;
        @SerializedName("outputFormat")
        @Expose
        private String outputFormat;
        @SerializedName("responseSize")
        @Expose
        private String responseSize;
        @SerializedName("mediaType")
        @Expose
        private String mediaType;
        @SerializedName("authenticationMethod")
        @Expose
        private String authenticationMethod;

        public String getSegmentTag() {
            return segmentTag;
        }

        public void setSegmentTag(String segmentTag) {
            this.segmentTag = segmentTag;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getReferenceNumber() {
            return referenceNumber;
        }

        public void setReferenceNumber(String referenceNumber) {
            this.referenceNumber = referenceNumber;
        }

        public String getFutureUse1() {
            return futureUse1;
        }

        public void setFutureUse1(String futureUse1) {
            this.futureUse1 = futureUse1;
        }

        public String getMemberCode() {
            return memberCode;
        }

        public void setMemberCode(String memberCode) {
            this.memberCode = memberCode;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPurpose() {
            return purpose;
        }

        public void setPurpose(String purpose) {
            this.purpose = purpose;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getFutureUse2() {
            return futureUse2;
        }

        public void setFutureUse2(String futureUse2) {
            this.futureUse2 = futureUse2;
        }

        public String getScoreType() {
            return scoreType;
        }

        public void setScoreType(String scoreType) {
            this.scoreType = scoreType;
        }

        public String getOutputFormat() {
            return outputFormat;
        }

        public void setOutputFormat(String outputFormat) {
            this.outputFormat = outputFormat;
        }

        public String getResponseSize() {
            return responseSize;
        }

        public void setResponseSize(String responseSize) {
            this.responseSize = responseSize;
        }

        public String getMediaType() {
            return mediaType;
        }

        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }

        public String getAuthenticationMethod() {
            return authenticationMethod;
        }

        public void setAuthenticationMethod(String authenticationMethod) {
            this.authenticationMethod = authenticationMethod;
        }

    }

    public class Names implements Serializable {

        @SerializedName("name")
        @Expose
        private Name name;

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }

    }

    public class Name implements Serializable {

        @SerializedName("consumerName1")
        @Expose
        private String consumerName1;
        @SerializedName("consumerName2")
        @Expose
        private String consumerName2;
        @SerializedName("consumerName3")
        @Expose
        private String consumerName3;
        @SerializedName("consumerName4")
        @Expose
        private String consumerName4;
        @SerializedName("consumerName5")
        @Expose
        private String consumerName5;
        @SerializedName("dateOfBirth")
        @Expose
        private String dateOfBirth;
        @SerializedName("gender")
        @Expose
        private String gender;

        public String getConsumerName1() {
            return consumerName1;
        }

        public void setConsumerName1(String consumerName1) {
            this.consumerName1 = consumerName1;
        }

        public String getConsumerName2() {
            return consumerName2;
        }

        public void setConsumerName2(String consumerName2) {
            this.consumerName2 = consumerName2;
        }

        public String getConsumerName3() {
            return consumerName3;
        }

        public void setConsumerName3(String consumerName3) {
            this.consumerName3 = consumerName3;
        }

        public String getConsumerName4() {
            return consumerName4;
        }

        public void setConsumerName4(String consumerName4) {
            this.consumerName4 = consumerName4;
        }

        public String getConsumerName5() {
            return consumerName5;
        }

        public void setConsumerName5(String consumerName5) {
            this.consumerName5 = consumerName5;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

    }

    public class Identifications implements Serializable {

        @SerializedName("identification")
        @Expose
        private Identification identification;

        public Identification getIdentification() {
            return identification;
        }

        public void setIdentification(Identification identification) {
            this.identification = identification;
        }

    }

    public class Identification implements Serializable {

        @SerializedName("panNo")
        @Expose
        private String panNo;
        @SerializedName("passportNumber")
        @Expose
        private String passportNumber;
        @SerializedName("dlNo")
        @Expose
        private String dlNo;
        @SerializedName("voterId")
        @Expose
        private String voterId;
        @SerializedName("uId")
        @Expose
        private String uId;
        @SerializedName("rationCardNo")
        @Expose
        private String rationCardNo;
        @SerializedName("additionalID1")
        @Expose
        private String additionalID1;
        @SerializedName("additionalID2")
        @Expose
        private String additionalID2;

        public String getPanNo() {
            return panNo;
        }

        public void setPanNo(String panNo) {
            this.panNo = panNo;
        }

        public String getPassportNumber() {
            return passportNumber;
        }

        public void setPassportNumber(String passportNumber) {
            this.passportNumber = passportNumber;
        }

        public String getDlNo() {
            return dlNo;
        }

        public void setDlNo(String dlNo) {
            this.dlNo = dlNo;
        }

        public String getVoterId() {
            return voterId;
        }

        public void setVoterId(String voterId) {
            this.voterId = voterId;
        }

        public String getUId() {
            return uId;
        }

        public void setUId(String uId) {
            this.uId = uId;
        }

        public String getRationCardNo() {
            return rationCardNo;
        }

        public void setRationCardNo(String rationCardNo) {
            this.rationCardNo = rationCardNo;
        }

        public String getAdditionalID1() {
            return additionalID1;
        }

        public void setAdditionalID1(String additionalID1) {
            this.additionalID1 = additionalID1;
        }

        public String getAdditionalID2() {
            return additionalID2;
        }

        public void setAdditionalID2(String additionalID2) {
            this.additionalID2 = additionalID2;
        }

    }

    public class Telephones_ implements Serializable {

        @SerializedName("telephone")
        @Expose
        private Telephone_ telephone;

        public Telephone_ getTelephone() {
            return telephone;
        }

        public void setTelephone(Telephone_ telephone) {
            this.telephone = telephone;
        }

    }

    public class Telephone_ implements Serializable {


    }

    public class Addresses_ implements Serializable {

        @SerializedName("address")
        @Expose
        private Address_ address;

        public Address_ getAddress() {
            return address;
        }

        public void setAddress(Address_ address) {
            this.address = address;
        }

    }

    public class Address_ implements Serializable {


    }

    public class Response implements Serializable {

        @SerializedName("cibilBureauResponse")
        @Expose
        private CibilBureauResponse cibilBureauResponse;

        public CibilBureauResponse getCibilBureauResponse() {
            return cibilBureauResponse;
        }

        public void setCibilBureauResponse(CibilBureauResponse cibilBureauResponse) {
            this.cibilBureauResponse = cibilBureauResponse;
        }

    }

    public class CibilBureauResponse implements Serializable {

        @SerializedName("bureauResponseRaw")
        @Expose
        private String bureauResponseRaw;
        @SerializedName("bureauResponseXml")
        @Expose
        private BureauResponseXml bureauResponseXml;
        @SerializedName("secondaryReportXml")
        @Expose
        private SecondaryReportXml secondaryReportXml;
        @SerializedName("isSucess")
        @Expose
        private String isSucess;

        public String getBureauResponseRaw() {
            return bureauResponseRaw;
        }

        public void setBureauResponseRaw(String bureauResponseRaw) {
            this.bureauResponseRaw = bureauResponseRaw;
        }

        public BureauResponseXml getBureauResponseXml() {
            return bureauResponseXml;
        }

        public void setBureauResponseXml(BureauResponseXml bureauResponseXml) {
            this.bureauResponseXml = bureauResponseXml;
        }

        public SecondaryReportXml getSecondaryReportXml() {
            return secondaryReportXml;
        }

        public void setSecondaryReportXml(SecondaryReportXml secondaryReportXml) {
            this.secondaryReportXml = secondaryReportXml;
        }

        public String getIsSucess() {
            return isSucess;
        }

        public void setIsSucess(String isSucess) {
            this.isSucess = isSucess;
        }

    }

    public class SecondaryReportXml implements Serializable {

        @SerializedName("root")
        @Expose
        private String root;

        public String getRoot() {
            return root;
        }

        public void setRoot(String root) {
            this.root = root;
        }

    }

    public class BureauResponseXml implements Serializable {

        @SerializedName("creditReport")
        @Expose
        private CreditReport creditReport;

        public CreditReport getCreditReport() {
            return creditReport;
        }

        public void setCreditReport(CreditReport creditReport) {
            this.creditReport = creditReport;
        }

    }

    public class CreditReport implements Serializable {

        @SerializedName("header")
        @Expose
        private Header_ header;
        @SerializedName("nameSegment")
        @Expose
        private NameSegment nameSegment;
        @SerializedName("idSegment")
        @Expose
        private IdSegment idSegment;
        @SerializedName("telephoneSegment")
        @Expose
        private TelephoneSegment telephoneSegment;
        @SerializedName("scoreSegment")
        @Expose
        private ScoreSegment scoreSegment;
        @SerializedName("address")
        @Expose
        private Address__ address;
        @SerializedName("enquiry")
        @Expose
        private Enquiry enquiry;
        @SerializedName("end")
        @Expose
        private End end;

        public Header_ getHeader() {
            return header;
        }

        public void setHeader(Header_ header) {
            this.header = header;
        }

        public NameSegment getNameSegment() {
            return nameSegment;
        }

        public void setNameSegment(NameSegment nameSegment) {
            this.nameSegment = nameSegment;
        }

        public IdSegment getIdSegment() {
            return idSegment;
        }

        public void setIdSegment(IdSegment idSegment) {
            this.idSegment = idSegment;
        }

        public TelephoneSegment getTelephoneSegment() {
            return telephoneSegment;
        }

        public void setTelephoneSegment(TelephoneSegment telephoneSegment) {
            this.telephoneSegment = telephoneSegment;
        }

        public ScoreSegment getScoreSegment() {
            return scoreSegment;
        }

        public void setScoreSegment(ScoreSegment scoreSegment) {
            this.scoreSegment = scoreSegment;
        }

        public Address__ getAddress() {
            return address;
        }

        public void setAddress(Address__ address) {
            this.address = address;
        }

        public Enquiry getEnquiry() {
            return enquiry;
        }

        public void setEnquiry(Enquiry enquiry) {
            this.enquiry = enquiry;
        }

        public End getEnd() {
            return end;
        }

        public void setEnd(End end) {
            this.end = end;
        }

    }

    public class Header_ implements Serializable {

        @SerializedName("segmentTag")
        @Expose
        private String segmentTag;
        @SerializedName("version")
        @Expose
        private String version;
        @SerializedName("referenceNumber")
        @Expose
        private String referenceNumber;
        @SerializedName("futureUse1")
        @Expose
        private String futureUse1;
        @SerializedName("memberCode")
        @Expose
        private String memberCode;
        @SerializedName("password")
        @Expose
        private String password;
        @SerializedName("purpose")
        @Expose
        private String purpose;
        @SerializedName("amount")
        @Expose
        private String amount;
        @SerializedName("futureUse2")
        @Expose
        private String futureUse2;
        @SerializedName("scoreType")
        @Expose
        private String scoreType;
        @SerializedName("outputFormat")
        @Expose
        private String outputFormat;
        @SerializedName("responseSize")
        @Expose
        private String responseSize;
        @SerializedName("mediaType")
        @Expose
        private String mediaType;
        @SerializedName("authenticationMethod")
        @Expose
        private String authenticationMethod;

        public String getSegmentTag() {
            return segmentTag;
        }

        public void setSegmentTag(String segmentTag) {
            this.segmentTag = segmentTag;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getReferenceNumber() {
            return referenceNumber;
        }

        public void setReferenceNumber(String referenceNumber) {
            this.referenceNumber = referenceNumber;
        }

        public String getFutureUse1() {
            return futureUse1;
        }

        public void setFutureUse1(String futureUse1) {
            this.futureUse1 = futureUse1;
        }

        public String getMemberCode() {
            return memberCode;
        }

        public void setMemberCode(String memberCode) {
            this.memberCode = memberCode;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPurpose() {
            return purpose;
        }

        public void setPurpose(String purpose) {
            this.purpose = purpose;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getFutureUse2() {
            return futureUse2;
        }

        public void setFutureUse2(String futureUse2) {
            this.futureUse2 = futureUse2;
        }

        public String getScoreType() {
            return scoreType;
        }

        public void setScoreType(String scoreType) {
            this.scoreType = scoreType;
        }

        public String getOutputFormat() {
            return outputFormat;
        }

        public void setOutputFormat(String outputFormat) {
            this.outputFormat = outputFormat;
        }

        public String getResponseSize() {
            return responseSize;
        }

        public void setResponseSize(String responseSize) {
            this.responseSize = responseSize;
        }

        public String getMediaType() {
            return mediaType;
        }

        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }

        public String getAuthenticationMethod() {
            return authenticationMethod;
        }

        public void setAuthenticationMethod(String authenticationMethod) {
            this.authenticationMethod = authenticationMethod;
        }

    }

    public class NameSegment implements Serializable {

        @SerializedName("length")
        @Expose
        private String length;
        @SerializedName("segmentTag")
        @Expose
        private String segmentTag;
        @SerializedName("consumerName1FieldLength")
        @Expose
        private String consumerName1FieldLength;
        @SerializedName("consumerName1")
        @Expose
        private String consumerName1;
        @SerializedName("consumerName2FieldLength")
        @Expose
        private String consumerName2FieldLength;
        @SerializedName("consumerName2")
        @Expose
        private String consumerName2;
        @SerializedName("consumerName3FieldLength")
        @Expose
        private String consumerName3FieldLength;
        @SerializedName("consumerName3")
        @Expose
        private String consumerName3;
        @SerializedName("dateOfBirthFieldLength")
        @Expose
        private String dateOfBirthFieldLength;
        @SerializedName("dateOfBirth")
        @Expose
        private String dateOfBirth;
        @SerializedName("genderFieldLength")
        @Expose
        private String genderFieldLength;
        @SerializedName("gender")
        @Expose
        private String gender;

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getSegmentTag() {
            return segmentTag;
        }

        public void setSegmentTag(String segmentTag) {
            this.segmentTag = segmentTag;
        }

        public String getConsumerName1FieldLength() {
            return consumerName1FieldLength;
        }

        public void setConsumerName1FieldLength(String consumerName1FieldLength) {
            this.consumerName1FieldLength = consumerName1FieldLength;
        }

        public String getConsumerName1() {
            return consumerName1;
        }

        public void setConsumerName1(String consumerName1) {
            this.consumerName1 = consumerName1;
        }

        public String getConsumerName2FieldLength() {
            return consumerName2FieldLength;
        }

        public void setConsumerName2FieldLength(String consumerName2FieldLength) {
            this.consumerName2FieldLength = consumerName2FieldLength;
        }

        public String getConsumerName2() {
            return consumerName2;
        }

        public void setConsumerName2(String consumerName2) {
            this.consumerName2 = consumerName2;
        }

        public String getConsumerName3FieldLength() {
            return consumerName3FieldLength;
        }

        public void setConsumerName3FieldLength(String consumerName3FieldLength) {
            this.consumerName3FieldLength = consumerName3FieldLength;
        }

        public String getConsumerName3() {
            return consumerName3;
        }

        public void setConsumerName3(String consumerName3) {
            this.consumerName3 = consumerName3;
        }

        public String getDateOfBirthFieldLength() {
            return dateOfBirthFieldLength;
        }

        public void setDateOfBirthFieldLength(String dateOfBirthFieldLength) {
            this.dateOfBirthFieldLength = dateOfBirthFieldLength;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getGenderFieldLength() {
            return genderFieldLength;
        }

        public void setGenderFieldLength(String genderFieldLength) {
            this.genderFieldLength = genderFieldLength;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

    }

    public class IdSegment implements Serializable {


    }

    public class TelephoneSegment implements Serializable {


    }

    public class ScoreSegment implements Serializable {


    }

    public class Address__ implements Serializable {


    }

    public class Enquiry implements Serializable {


    }

    public class End implements Serializable {

        @SerializedName("segmentTag")
        @Expose
        private String segmentTag;
        @SerializedName("totalLength")
        @Expose
        private String totalLength;

        public String getSegmentTag() {
            return segmentTag;
        }

        public void setSegmentTag(String segmentTag) {
            this.segmentTag = segmentTag;
        }

        public String getTotalLength() {
            return totalLength;
        }

        public void setTotalLength(String totalLength) {
            this.totalLength = totalLength;
        }

    }
}
