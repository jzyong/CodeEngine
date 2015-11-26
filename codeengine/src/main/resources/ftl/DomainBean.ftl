package cn.xm.dota.base.biz.domain;

import cn.xm.dota.base.storage.dto.<@upperFC>${className}</@upperFC>Dto;
<#list properties as pro>
<#if pro.proType == "Date"> 
import java.util.Date;  
<#break>
</#if>
</#list>

/**
*
* @author JiangZhiYong
* @date ${date}
**/
public class ${className}{

	public static ${className} of(${className}Dto dto){
		${className} <@lowerFC>${className}</@lowerFC> = new ${className}();
		<#list properties as pro>
		<@lowerFC>${className}</@lowerFC>.${pro.proName} = dto.get<@upperFC>${pro.proName}</@upperFC>();
		</#list>
		return <@lowerFC>${className}</@lowerFC>;
	}
	
	public ${className}Dto dto(){
		${className}Dto dto=new ${className}Dto();
		<#list properties as pro>
		dto.set<@upperFC>${pro.proName}</@upperFC>(this.${pro.proName});
		</#list>
		return dto;
	}

<#list properties as pro>
	private ${pro.proType} ${pro.proName};	<#if pro.description !="">		//${pro.description}<#else>	</#if>
</#list>

<#list properties as pro>
	<#if pro.description !="">/** ${pro.description} */</#if>
	public ${pro.proType} get<@upperFC>${pro.proName}</@upperFC>(){
		return this.${pro.proName};
	}
	
</#list>

}