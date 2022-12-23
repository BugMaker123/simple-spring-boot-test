package com.example.simplespringboottest.prac.worktools.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author dyh
 * @since 2020-07-22
 */
@Data
@ApiModel(value = "PcOrganizationDotInfo对象", description = "网点信息")
public class PcOrganizationDotInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 机构编号
     */
    @ApiModelProperty(value = "机构编号")
    private String orgId;

    /**
     * 窗口编码
     */
    @ApiModelProperty(value = "窗口编码")
    private String wCode;

    /**
     * 窗口性质（1：一级网点、2：分部、3：服务部、4：航空、5：货代、6：分拨中心）
     */
    @ApiModelProperty(value = "窗口性质（1：一级网点、2：分部、3：服务部、4：航空、5：货代、6：分拨中心）")
    private Integer wQulality;

    /**
     * 窗口名称
     */
    @ApiModelProperty(value = "窗口名称")
    private String wName;

    /**
     * 门店类型（自建普通门店,社区便利店(自建)、社区代办点(合作)、仓储）
     */
    @ApiModelProperty(value = "门店类型（自建普通门店,社区便利店(自建)、社区代办点(合作)、仓储）")
    private String wType;

    /**
     * 航空窗口类型
     */
    @ApiModelProperty(value = "航空窗口类型")
    private String voyageWinType;

    /**
     * 窗口类型 直营航空、网点航空
     */
    @ApiModelProperty(value = "窗口类型 直营航空、网点航空")
    private String winType;

    /**
     * 仓储经营方式
     */
    @ApiModelProperty(value = "仓储经营方式")
    private String etcBusinessType;

    /**
     * 是否为淘宝客户窗口
     */
    @ApiModelProperty(value = "是否为淘宝客户窗口")
    private String isTaobao;

    /**
     * 是否有营业执照
     */
    @ApiModelProperty(value = "是否有营业执照")
    private String hasLicense;

    /**
     * 操作员密码
     */
    @ApiModelProperty(value = "操作员密码")
    private String operatorPsw;

    /**
     * 窗口所属大区
     */
    @ApiModelProperty(value = "窗口所属大区")
    private String wRegion;

    /**
     * 窗口所属大区名称
     */
    @ApiModelProperty(value = "窗口所属大区名称")
    private String wRegionName;

    /**
     * 窗口行政区域省
     */
    @ApiModelProperty(value = "窗口行政区域省")
    private String wProvince;

    /**
     * 窗口行政区域省名称
     */
    @ApiModelProperty(value = "窗口行政区域省名称")
    private String wProvinceName;

    /**
     * 窗口行政区域省
     */
    @ApiModelProperty(value = "窗口行政区域业务省")
    private String wProvinceb;

    /**
     * 窗口行政区域省名称
     */
    @ApiModelProperty(value = "窗口行政区域业务省名称")
    private String wProvincebName;

    /**
     * 窗口行政区域市
     */
    @ApiModelProperty(value = "窗口行政区域市")
    private String wCity;

    /**
     * 窗口行政区域市名称
     */
    @ApiModelProperty(value = "窗口行政区域市名称")
    private String wCityName;

    /**
     * 窗口行政区域区
     */
    @ApiModelProperty(value = "窗口行政区域区")
    private String wDistrict;

    /**
     * 窗口行政区域区名称
     */
    @ApiModelProperty(value = "窗口行政区域区名称")
    private String wDistrictName;

    /**
     * 窗口行政区域街道
     */
    @ApiModelProperty(value = "窗口行政区域街道")
    private String wStreet;

    /**
     * 窗口行政区域街道名称
     */
    @ApiModelProperty(value = "窗口行政区域街道名称")
    private String wStreetName;

    /**
     * 公司编码（上级公司编码）
     */
    @ApiModelProperty(value = "公司编码（上级公司编码）")
    private String pwCode;

    /**
     * 所属分拨中心(中转站)编码
     */
    @ApiModelProperty(value = "所属分拨中心(中转站)编码")
    private String transferStationCode;

    /**
     * 公司办公地址省
     */
    @ApiModelProperty(value = "公司办公地址省")
    private String officeProvince;

    /**
     * 公司办公地址市
     */
    @ApiModelProperty(value = "公司办公地址市")
    private String officeCity;

    /**
     * 公司办公地址区
     */
    @ApiModelProperty(value = "公司办公地址区")
    private String officeDistrict;

    /**
     * 公司办公地址街道
     */
    @ApiModelProperty(value = "公司办公地址街道")
    private String officeStreet;

    /**
     * 公司办公地址门牌地址
     */
    @ApiModelProperty(value = "公司办公地址门牌地址")
    private String officeAddr;

    /**
     * 公司办公地址邮编
     */
    @ApiModelProperty(value = "公司办公地址邮编")
    private String officePostcode;

    /**
     * 公司负责人
     */
    @ApiModelProperty(value = "公司负责人")
    private String companyPrincipal;

    /**
     * 公司电话
     */
    @ApiModelProperty(value = "公司电话")
    private String companyPhone;

    /**
     * 公司负责人手机
     */
    @ApiModelProperty(value = "公司负责人手机")
    private String principalMobile;

    /**
     * 公司查询电话
     */
    @ApiModelProperty(value = "公司查询电话")
    private String companyQueryPhone;

    /**
     * 公司下单电话
     */
    @ApiModelProperty(value = "公司下单电话")
    private String companyOrderPhone;

    /**
     * 公司投诉电话
     */
    @ApiModelProperty(value = "公司投诉电话")
    private String companyComplaintPhone;

    /**
     * 公司传真电话
     */
    @ApiModelProperty(value = "公司传真电话")
    private String companyFaxPhone;

    /**
     * 日走件量
     */
    @ApiModelProperty(value = "日走件量")
    private Integer dailyPieces;

    /**
     * 现有手持终端数
     */
    @ApiModelProperty(value = "现有手持终端数")
    private Integer currentHandTerminal;

    /**
     * 现有电子称
     */
    @ApiModelProperty(value = "现有电子称")
    private Integer currentEws;

    /**
     * 现有营业面积
     */
    @ApiModelProperty(value = "现有营业面积")
    private Integer currentBusinessArea;

    /**
     * 现有办公电脑
     */
    @ApiModelProperty(value = "现有办公电脑")
    private Integer currentOfficePc;

    /**
     * 派送范围
     */
    @ApiModelProperty(value = "派送范围")
    private String deliveryRange;

    /**
     * 不派送范围
     */
    @ApiModelProperty(value = "不派送范围")
    private String noDeliveryRange;

    /**
     * 员工人数
     */
    @ApiModelProperty(value = "员工人数")
    private Integer empNum;

    /**
     * 快递上岗人数
     */
    @ApiModelProperty(value = "快递上岗人数")
    private Integer postmanNum;

    /**
     * 营业期限
     */
    @ApiModelProperty(value = "营业期限")
    private String businessLimitTime;

    /**
     * 许可证期限
     */
    @ApiModelProperty(value = "许可证期限")
    private String licenseLimitTime;

    /**
     * 业务类型
     */
    @ApiModelProperty(value = "业务类型")
    private String businessType;

    /**
     * 提货人名称
     */
    @ApiModelProperty(value = "提货人名称")
    private String consigneeName;

    /**
     * 提货人电话
     */
    @ApiModelProperty(value = "提货人电话")
    private String consigneePhone;

    /**
     * 提货方式
     */
    @ApiModelProperty(value = "提货方式")
    private String consigneeType;

    /**
     * 注册执照名称
     */
    @ApiModelProperty(value = "注册执照名称")
    private String registerLicenseName;

    /**
     * 法定代表人
     */
    @ApiModelProperty(value = "法定代表人")
    private String legalPerson;

    /**
     * 注册执照地址
     */
    @ApiModelProperty(value = "注册执照地址")
    private String registerLicenseAddr;

    /**
     * 注册执照号
     */
    @ApiModelProperty(value = "注册执照号")
    private String registerLicenseNo;

    /**
     * 工商执照发证日期
     */
    @ApiModelProperty(value = "工商执照发证日期")
    private String registerLicenseDate;

    /**
     * 经营许可证号
     */
    @ApiModelProperty(value = "经营许可证号")
    private String businessLicenseNo;

    /**
     * 经营许可证发证日期
     */
    @ApiModelProperty(value = "经营许可证发证日期")
    private String businessLicenseDate;

    /**
     * 税务登记号
     */
    @ApiModelProperty(value = "税务登记号")
    private String taxRegisterNo;

    /**
     * 开户行名称
     */
    @ApiModelProperty(value = "开户行名称")
    private String accountBankName;

    /**
     * 开户行账号
     */
    @ApiModelProperty(value = "开户行账号")
    private String account;

    /**
     * 开户行地址
     */
    @ApiModelProperty(value = "开户行地址")
    private String accountBankAddr;

    /**
     * 货代承运业务
     */
    @ApiModelProperty(value = "货代承运业务")
    private String freightForwardingBusiness;

    /**
     * 进港操作方式
     */
    @ApiModelProperty(value = "进港操作方式")
    private String entryOperationType;

    /**
     * 出港操作方式
     */
    @ApiModelProperty(value = "出港操作方式")
    private String outOperationType;

    /**
     * 承运航线
     */
    @ApiModelProperty(value = "承运航线")
    private String carrierRoutes;

    /**
     * 网点状态
     */
    @ApiModelProperty(value = "网点状态")
    private String cpStatus;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 创建人工号
     */
    @ApiModelProperty(value = "创建人工号")
    private String createUserCode;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "zh", timezone = "GMT+8")
    private Date updateDate;

    /**
     * 更新人工号
     */
    @ApiModelProperty(value = "更新人工号")
    private String updateUserCode;

    /**
     * 派送范围备注
     */
    @ApiModelProperty(value = "派送范围备注")
    private String deliveryRangeRemark;

    /**
     * 窗口行政所属国家
     */
    @ApiModelProperty(value = "窗口行政所属国家")
    private String winBelongCountry;

    /**
     * 窗口是否国际部  0:否 1：是
     */
    @ApiModelProperty(value = "窗口是否国际部  0:否 1：是")
    private String winIsInternational;

    /**
     * 公司办公地址国家
     */
    @ApiModelProperty(value = "公司办公地址国家")
    private String companyOfficeCountry;

    /**
     * 网点/分拨/服务部负责人身份证
     */
    @ApiModelProperty(value = "网点/分拨/服务部负责人身份证")
    private String cpPrincipalCardNo;

    /**
     * 营业期限日期
     */
    @ApiModelProperty(value = "营业期限日期")
    private String businessEndDate;

    /**
     * 许可证期限日期
     */
    @ApiModelProperty(value = "许可证期限日期")
    private String licenseEndDate;

    /**
     * 查件负责人
     */
    @ApiModelProperty(value = "查件负责人")
    private String queryPiecesPrincipal;

    /**
     * 客服负责人
     */
    @ApiModelProperty(value = "客服负责人")
    private String customerServicePrincipal;

    /**
     * 客服电话
     */
    @ApiModelProperty(value = "客服电话")
    private String customerServicePhone;

    /**
     * 网点所属省公司编码
     */
    @ApiModelProperty(value = "网点所属省公司编码")
    private String cpProvinceCompanyCode;

    /**
     * 操作场地
     */
    @ApiModelProperty(value = "操作场地")
    private String operationPlace;

    /**
     * 机构经度
     */
    @ApiModelProperty(value = "机构经度")
    private BigDecimal longitude;

    /**
     * 机构纬度
     */
    @ApiModelProperty(value = "机构纬度")
    private BigDecimal latitude;

    /**
     * 监控点
     */
    @ApiModelProperty(value = "监控点")
    private String[] monitorLocations;

    /**
     * 预付款状态-网点  0-正常启用,1-欠费 2-冻结
     */
    @ApiModelProperty(value = "0-正常启用,1-欠费 2-冻结")
    private Integer advancePaymentState;

    /**
     * 是否合规
     */
    private Integer isCompliance;

    /**
     * 法人身份证号
     */
    private String legalpersonIdCardNo;

    /**
     * 法人电话
     */
    private String legalpersonTel;

    /**
     * 覆盖村组
     */
    private String coverVillages;
}

