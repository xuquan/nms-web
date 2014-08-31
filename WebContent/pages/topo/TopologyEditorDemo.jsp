<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>TWaver HTML5 - Topology Editor Demo</title>
    <link rel="stylesheet" href="<s:url value="/css/base.css"/>" type="text/css">
    <script type="text/javascript" src="<s:url value="/js/twaver.js"/>"></script>
    <script type="text/javascript" src="<s:url value="/js/demo.js"/>"></script>
    <script type="text/javascript" src="<s:url value="/js/TopologyEditorDemo.js"/>"></script>
    <script type="text/javascript">
        var topologyEditorDemo = new TopologyEditorDemo();
    </script>
</head>
<body onload="topologyEditorDemo.init()">
    <div id='main'>
    </div>
</body>
</html>
