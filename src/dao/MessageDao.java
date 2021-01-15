package dao;

import entity.MessageBean;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.DBCon;

import java.sql.Connection;
import java.util.List;

public class MessageDao {
    public List<MessageBean> getMessages() throws Exception {
        Connection conn = DBCon.getConnection();
        String sql = "select * from MessageInfo";
        try {
            return new QueryRunner()
                    .query(conn, sql, new BeanListHandler<MessageBean>(MessageBean.class));
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int delete(int[] mid) throws Exception {
        Connection conn = DBCon.getConnection();
        int row = 0;
        try {
            for (int i = 0; i < mid.length; i++) {
                String sql = "delete from MessageInfo where id =?";
                row = new QueryRunner().update(conn, sql, mid[i]);
                if (i == mid.length) {
                    break;
                }
            }
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return row;
    }
}
