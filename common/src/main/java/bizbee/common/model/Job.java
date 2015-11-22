package bizbee.common.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;
import java.io.Serializable;

@Document(collection = "jobs")
@JsonSerialize(
        include = JsonSerialize.Inclusion.NON_NULL
)
public class Job implements Serializable {

    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private int number;

    private String ukey;
    private String acctId;

    @JsonIgnore
    private long pid;
    private int status;
    private String category;
    private int categoryId;
    private String notes;

    private Double price;


    private String phone;


    private String customerCancelReason;
    private String customerCancelNotes;

    private int pending;
    private int retries;
    private int driverCancelled;

    private int jobCode;
    private String displayStatus;

    private String driverKey;

    private int ccAuthorized;

    private int jobType;
    private long assignedCompany;
    private int providerPaymentId;

    @JsonIgnore
    private String ctxId;

    private String firstName;
    private String lastName;
    private String name;

    private int btaId;
    private String bta;

    private String app;

    private String promoId;
    private String promoCode;

    private int test;
    private long reason;
    private String displayReason;

    private Double chargedPrice;

    private Integer estimatedTowTime;
    private Double estimatedTowMiles;

    private long updatedAt;

    private String partnerName;

    public Job() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUkey() {
        return ukey;
    }

    public void setUkey(String ukey) {
        this.ukey = ukey;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerCancelReason() {
        return customerCancelReason;
    }

    public void setCustomerCancelReason(String customerCancelReason) {
        this.customerCancelReason = customerCancelReason;
    }

    public String getCustomerCancelNotes() {
        return customerCancelNotes;
    }

    public void setCustomerCancelNotes(String customerCancelNotes) {
        this.customerCancelNotes = customerCancelNotes;
    }

    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }

    public int getDriverCancelled() {
        return driverCancelled;
    }

    public void setDriverCancelled(int driverCancelled) {
        this.driverCancelled = driverCancelled;
    }

    public int getJobCode() {
        return jobCode;
    }

    public void setJobCode(int jobCode) {
        this.jobCode = jobCode;
    }

    public String getDisplayStatus() {
        return displayStatus;
    }

    public void setDisplayStatus(String displayStatus) {
        this.displayStatus = displayStatus;
    }

    public String getDriverKey() {
        return driverKey;
    }

    public void setDriverKey(String driverKey) {
        this.driverKey = driverKey;
    }

    public int getCcAuthorized() {
        return ccAuthorized;
    }

    public void setCcAuthorized(int ccAuthorized) {
        this.ccAuthorized = ccAuthorized;
    }

    public int getJobType() {
        return jobType;
    }

    public void setJobType(int jobType) {
        this.jobType = jobType;
    }

    public long getAssignedCompany() {
        return assignedCompany;
    }

    public void setAssignedCompany(long assignedCompany) {
        this.assignedCompany = assignedCompany;
    }

    public int getProviderPaymentId() {
        return providerPaymentId;
    }

    public void setProviderPaymentId(int providerPaymentId) {
        this.providerPaymentId = providerPaymentId;
    }

    public String getCtxId() {
        return ctxId;
    }

    public void setCtxId(String ctxId) {
        this.ctxId = ctxId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBtaId() {
        return btaId;
    }

    public void setBtaId(int btaId) {
        this.btaId = btaId;
    }

    public String getBta() {
        return bta;
    }

    public void setBta(String bta) {
        this.bta = bta;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getPromoId() {
        return promoId;
    }

    public void setPromoId(String promoId) {
        this.promoId = promoId;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public long getReason() {
        return reason;
    }

    public void setReason(long reason) {
        this.reason = reason;
    }

    public String getDisplayReason() {
        return displayReason;
    }

    public void setDisplayReason(String displayReason) {
        this.displayReason = displayReason;
    }

    public Double getChargedPrice() {
        return chargedPrice;
    }

    public void setChargedPrice(Double chargedPrice) {
        this.chargedPrice = chargedPrice;
    }

    public Integer getEstimatedTowTime() {
        return estimatedTowTime;
    }

    public void setEstimatedTowTime(Integer estimatedTowTime) {
        this.estimatedTowTime = estimatedTowTime;
    }

    public Double getEstimatedTowMiles() {
        return estimatedTowMiles;
    }

    public void setEstimatedTowMiles(Double estimatedTowMiles) {
        this.estimatedTowMiles = estimatedTowMiles;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
}
