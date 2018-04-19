function checkrst(data) {
    dataobj=JSON.parse(data);
    if(dataobj.rst_code === 0){
        return dataobj.rst_data;
    }
    $.messager.alert('Warning',   dataobj.rst_msg);
    return false;
}