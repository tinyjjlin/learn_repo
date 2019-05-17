app.post("/moveFile",function(req,res){
    let fileList = req.body.list;
    console.log("req body...."+fileList);
    if(fileList ===undefined || fileList === null || fileList.length <1){
        console.log("fileList.....1");
        res.send({"status":"bad","msg":"move file failed"});
    }else{
        let fileHandlerInstance = new fileHandler();
        fileHandlerInstance.transferFile(req.body.list);
        if(fileHandlerInstance.getErrorValue()){
            console.log("fileList.....2");
            res.send({"status":"bad","msg":"move file failed"});
        }else{
            console.log("fileList.....3");
            res.send({"status":"ok","msg":"move file success"});
        }

    }
        
    
});