package xaut.meal.system.service;

public interface JedisUtil {
    /**
     * ���뻺��
     * @param key
     * @param value
     */
    void putObject(Object key, Object value);
    /**
     * �������
     * @param arg0
     * @return
     */
    Object removeObject(Object arg0);
    /**
     * �ӻ����л�ȡ
     * @param arg0
     * @return
     */
    Object getObject(Object arg0);
}
