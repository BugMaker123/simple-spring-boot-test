package com.example.simplespringboottest.prac.worktools.bo;


import com.fasterxml.jackson.annotation.JsonFormat;
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
public class PcOrganizationInfo implements Serializable {

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
     * 机构编码
     */
    @ApiModelProperty(value = "机构编码")
    private String orgCode;

    /**
     * 机构名称
     */
    @ApiModelProperty(value = "机构名称")
    private String orgName;

    /**
     * 机构层级
     */
    @ApiModelProperty(value = "机构层级")
    private Integer orgLevel;

    /**
     * 机构等级（0单位 1一级总部和分拨部门,2二级总部和分拨部门,3----）
     */
    @ApiModelProperty(value = "机构等级（0单位 1一级总部和分拨部门,2二级总部和分拨部门,3----）")
    private Integer orgDegree;

    /**
     * 父机构编号
     */
    @ApiModelProperty(value = "父机构编号")
    private String parentOrgId;

    /**
     * 机构序列
     */
    @ApiModelProperty(value = "机构序列")
    private String orgOrder;

    /**
     * 机构类型（1 总部 2 分拨中心 3 区域（国家，省，市） 4 网点 5大区组织--已经取消 6省级分拨）
     */
    @ApiModelProperty(value = "机构类型（1 总部 2 分拨中心 3 区域（国家，省，市） 4 网点 5大区组织--已经取消 6省级分拨）")
    private Integer orgType;

    /**
     * 机构地址
     */
    @ApiModelProperty(value = "机构地址")
    private String orgAddr;

    /**
     * 邮编
     */
    @ApiModelProperty(value = "邮编")
    private String postcode;

    /**
     * 机构主管岗位
     */
    @ApiModelProperty(value = "机构主管岗位")
    private String orgManageJob;

    /**
     * 机构主管人员
     */
    @ApiModelProperty(value = "机构主管人员")
    private String orgManagerId;

    /**
     * 机构管理员
     */
    @ApiModelProperty(value = "机构管理员")
    private String orgManager;

    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String linkman;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String linkPhone;

    /**
     * 电子邮件
     */
    @ApiModelProperty(value = "电子邮件")
    private String email;

    /**
     * 网站地址
     */
    @ApiModelProperty(value = "网站地址")
    private String websiteAddr;

    /**
     * 生效日期
     */
    @ApiModelProperty(value = "生效日期")
    private Date effectTime;

    /**
     * 失效日期
     */
    @ApiModelProperty(value = "失效日期")
    private Date loseEffectTime;

    /**
     * 机构状态
     */
    @ApiModelProperty(value = "机构状态")
    private Integer orgStatus;

    /**
     * 所属地域
     */
    @ApiModelProperty(value = "所属地域")
    private String area;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createUserCode;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "zh", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人")
    private String updateUserCode;

    /**
     * 排列顺序编号
     */
    @ApiModelProperty(value = "排列顺序编号")
    private String sortOrderId;

    /**
     * 是否为叶子节点 0：是 1-否
     */
    @ApiModelProperty(value = "是否为叶子节点 0：是 1-否")
    private Integer isLeaf;

    /**
     * 叶子节点数
     */
    @ApiModelProperty(value = "叶子节点数")
    private Integer subCount;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 所属中转站编码
     */
    @ApiModelProperty(value = "所属中转站编码")
    private String belongTransCode;

    /**
     * 所属中转站名字
     */
    @ApiModelProperty(value = "所属中转站名字")
    private String belongTransName;

    /**
     * 状态（1正常使用、2暂停、3欠费关闭、4预备关闭、9删除'）
     */
    @ApiModelProperty(value = "状态（1正常使用、2暂停、3欠费关闭、4预备关闭、9删除'）")
    private Integer status;

    /**
     * 机构名称全称
     */
    @ApiModelProperty(value = "机构名称全称")
    private String orgNameFull;

    /**
     * 业务系统编码
     */
    @ApiModelProperty(value = "业务系统编码")
    private String businessCode;

    /**
     * 成本中心
     */
    @ApiModelProperty(value = "成本中心")
    private String costCenter;

    /**
     * 成本中心描述
     */
    @ApiModelProperty(value = "成本中心描述")
    private String costCenterDesc;

    /**
     * 机构对应的区域类型
     */
    @ApiModelProperty(value = "机构对应的区域类型")
    private String areaOrgType;

    /**
     * 部门费用
     */
    @ApiModelProperty(value = "部门费用")
    private String departCharge;

    /**
     * 单位薪资范围
     */
    @ApiModelProperty(value = "单位薪资范围")
    private String salaryRange;

    /**
     * 公司人事范围
     */
    @ApiModelProperty(value = "公司人事范围")
    private String hrRange;

    /**
     * 网点类别
     */
    @ApiModelProperty(value = "网点类别")
    private String cpType;

    /**
     * 机构全名称
     */
    @ApiModelProperty(value = "机构全名称")
    private String orgFullName;

    /**
     * 单位id ,  0为没有单位
     */
    @ApiModelProperty(value = "单位id ,  0为没有单位")
    private Integer companyId;

    /**
     * 单位SEQ , 0为没有单位
     */
    @ApiModelProperty(value = "单位SEQ , 0为没有单位")
    private String companySeq;

    /**
     * 单位/公司名称 0为没有单位
     */
    @ApiModelProperty(value = "单位/公司名称 0为没有单位")
    private String companyName;

    /**
     * 在RTX中组织机构编号
     */
    @ApiModelProperty(value = "在RTX中组织机构编号")
    private String rtxid;

    /**
     * 在RTX中父组织机构编号
     */
    @ApiModelProperty(value = "在RTX中父组织机构编号")
    private String parentRtxid;

    /**
     * 所属中转站ID
     */
    @ApiModelProperty(value = "所属中转站ID")
    private String belongTransId;

    /**
     * EXCHANGE组织机构编号
     */

    private String adid;

    /**
     * EXCHANGE父组织机构编号
     */

    private String parentAdid;

    /**
     * 机构经度
     */

    private BigDecimal longitude;

    /**
     * 机构纬度
     */

    private BigDecimal latitude;

    /**
     * 监控点
     */

    private String[] monitorLocations;
}

