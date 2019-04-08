package guet.ty.member.VO;
import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * 数据表格视图对象
 * @param <T>
 */
@Data
public class TableVO<T> {
    private PageInfo pageInfo;
    private List<T> data;

    public TableVO() {
    }

    public TableVO(PageInfo pageInfo, List<T> data) {
        this.pageInfo = pageInfo;
        this.data = data;
    }
}
