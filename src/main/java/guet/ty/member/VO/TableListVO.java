package guet.ty.member.VO;
import lombok.Data;

import java.util.List;

/**
 * 数据表格视图对象
 * @param <T>
 */
@Data
public class TableListVO<T> {
    private Long code;
    private Long count;
    private List<T> data;

    public TableListVO() {
    }

    public TableListVO(Long code) {
        this.code = code;
    }

    public TableListVO(Long count, List<T> data) {
        this.code = 0L;
        this.count = count;
        this.data = data;
    }
}
