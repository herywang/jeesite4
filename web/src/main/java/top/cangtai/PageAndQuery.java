package top.cangtai;

import com.jeesite.common.entity.Page;
import org.springframework.data.mongodb.core.query.Query;

public interface PageAndQuery {

    Query getQuery(String orderBy);

    void setPage(Page<?> page);

    Page<?> getPage();

}
