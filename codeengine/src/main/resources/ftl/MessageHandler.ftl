package cn.xm.dota.base.biz.handler.${package};

import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ${package}.<@upperFC>${package}</@upperFC>.PB${className}Request;
import ${package}.<@upperFC>${package}</@upperFC>.PB${className}Responese;
import cn.xm.dota.base.biz.handler.player.PlayerLoadingHandler;
import cn.xm.dota.base.network.AbsPbHandler;

/**
*
* @author JiangZhiYong
* @date ${date}
**/
@Component
public class ${className}Handler extends AbsPbHandler<PB${className}Request,PB${className}Responese>{

	public ${className}Handler(){
		super(PB${className}Request.class, PB${className}Responese.class);
	}

  	@Transactional
    @Override
    public PB${className}Responese handle(PB${className}Request request, ChannelHandlerContext context) {
        long playerId = context.attr(PlayerLoadingHandler.PLAYER_ID).get();

        return null;
    }

}