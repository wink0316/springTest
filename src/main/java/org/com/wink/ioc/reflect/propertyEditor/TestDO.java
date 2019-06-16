package org.com.wink.ioc.reflect.propertyEditor;

public class TestDO {

    private String nodeName;
    private NodeDO nodeDO;

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public NodeDO getNodeDO() {
        return nodeDO;
    }

    public void setNodeDO(NodeDO nodeDO) {
        this.nodeDO = nodeDO;
    }

    @Override
    public String toString() {
        return "TestDO{" +
                "nodeName='" + nodeName + '\'' +
                ", nodeDO=" + nodeDO +
                '}';
    }
}
