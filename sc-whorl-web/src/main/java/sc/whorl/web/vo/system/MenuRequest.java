package sc.whorl.web.vo.system;

import lombok.Data;
import sc.whorl.system.commons.PageCondition;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Data
public class MenuRequest extends PageCondition {
    private String menuName;

}
