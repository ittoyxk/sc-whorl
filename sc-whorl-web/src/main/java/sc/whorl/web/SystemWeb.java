package sc.whorl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sc.whorl.logic.service.system.MenuService;
import sc.whorl.system.commons.MsgResponseBody;
import sc.whorl.web.vo.system.MenuPremInfo;
import sc.whorl.web.vo.system.MenuRequest;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping(value = "/sc/user/system")
@Api(value = "SystemWeb", description = "系统相关接口,包括菜单缓存字典等")
public class SystemWeb {
    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "获取菜单", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getMenu", method = RequestMethod.POST, produces = {"application/json"})
    public MsgResponseBody getMenu() {
        return MsgResponseBody.success().setResult(menuService.getMenu());
    }

    @ApiOperation(value = "删除菜单", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getMenu", method = RequestMethod.POST, produces = {"application/json"})
    public MsgResponseBody delMenu(Long menuId) {
        menuService.delMenu(menuId);
        return MsgResponseBody.success().setResult("删除成功!");
    }

    @ApiOperation(value = "添加菜单", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/addMenu", method = RequestMethod.POST, produces = {"application/json"})
    public MsgResponseBody addMenu(@RequestBody MenuPremInfo menuPremInfo) {
        menuService.addMenu(menuPremInfo);
        return MsgResponseBody.success().setResult("添加成功!");
    }

    @ApiOperation(value = "查询菜单列表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getMenu", method = RequestMethod.POST, produces = {"application/json"})
    public MsgResponseBody delMenu(@RequestBody MenuRequest menuRequest) {
        return MsgResponseBody.success().setResult(menuService.searchListMenu(menuRequest));
    }



}