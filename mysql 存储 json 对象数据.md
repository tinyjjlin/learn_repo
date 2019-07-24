# mysql 存储 json 对象数据
##

//    @ApiOperation("订单列表（根据订单状态分类）")
//    @PostMapping("/api/orderProcess/list/orderStatus")
//    public Object orderListByStatus(@RequestBody OrderListQueryParams query, HttpServletRequest request) {
//        String userId = SecurityUtils.getUserIdFromRequest(request);
//        PageHelper.startPage(query.getPage(), query.getLimit());
//
//        List<OrderForm> orderBaseInfoList = orderProcessDao.selectOrderInfo(userId,query.getStatusList() , query.getSearch());
//        PageInfo pageInfo = new PageInfo(orderBaseInfoList);
//        List<OrderInfo> list = new ArrayList <>();
//        if(list != null && orderBaseInfoList.size()>0){
//            for(OrderForm orderForm :orderBaseInfoList){
//                OrderInfo orderInfo = orderProcessSearchService.convertToOrderInfo(userId,orderForm );
//                list.add(orderInfo);
//            }
//        }
//        pageInfo.setList(list);
//        return pageInfo;
//    }
//
//
//    @ApiOperation("订单列表（根据排除掉的订单状态分类）")
//    @PostMapping("/api/orderProcess/list/excludeStatus")
//    public Object orderListByExcludeStatus(@RequestBody OrderListQueryParams query, HttpServletRequest request) {
//        String userId = SecurityUtils.getUserIdFromRequest(request);
//        PageHelper.startPage(query.getPage(), query.getLimit());
//
//
//        List<OrderForm> orderBaseInfoList = orderProcessDao.selectOrderInfoExtra(userId, query.getStatusList(), query.getSearch());
//        PageInfo pageInfo = new PageInfo(orderBaseInfoList);
//
//        List<OrderInfo> list = new ArrayList <>();
//
//        if(list != null && orderBaseInfoList.size()>0){
//            for(OrderForm orderForm :orderBaseInfoList){
//                OrderInfo orderInfo = orderProcessSearchService.convertToOrderInfo(userId,orderForm );
//                list.add(orderInfo);
//            }
//        }
//        pageInfo.setList(list);
//        return pageInfo;
//    }


//
//    @ApiOperation("下载压缩文件")
//    @GetMapping("/api/downloadZipFile")
//    public Object downloadZipFile(@RequestParam("procId") String procId, @RequestParam("resType") String resType, HttpServletResponse response) {
//        String downloadFileName = "";
//        List <String> resUrlList = processResService.getProcessRes(procId, resType);
//        //压缩下载
//        List <File> fileList = new ArrayList <>();
//        if (resUrlList != null) {
//            for (String resUrl : resUrlList) {
//                log.info("## .................res file:" + uploadDir + File.separator + resUrl);
//                File file = new File(uploadDir + resUrl);
//
//                if (file != null && file.isFile()) {
//                    fileList.add(file);
//                    downloadFileName = file.getName();
//                }
//            }
//        }
//        if (fileList == null || fileList.size() < 1) {
//            return RespResult.fail("download_no", "没有可下载的资源文件！");
//        }
//
//        // 创建一个临时压缩文件
//        String zipName;
//        if (StringUtils.isEmpty(downloadFileName)) {
//            zipName = UUID.randomUUID().toString() + ".zip";
//        } else {
//            zipName = downloadFileName + ".zip";
//        }
//        File fileZip = new File(uploadDir + zipName);
//        try {
//            fileZip.createNewFile();
//            if (!fileZip.exists()) {
//                fileZip.createNewFile();
//            }
//
//            downLoadFiles(fileList, fileZip, response);
//        } catch (Exception e) {
//            log.info("## download file failed!");
//            log.warn(e.getMessage().toString());
//        }
//
//        return "下载成功";
//    }


    public static HttpServletResponse downLoadFiles(List <File> files, File file, HttpServletResponse response) throws Exception {

        try {
            // List<File> 作为参数传进来，就是把多个文件的路径放到一个list里面

            response.reset();
            // response.getWriter()
            // 创建文件输出流
            FileOutputStream fous = new FileOutputStream(file);
            ZipOutputStream zipOut = new ZipOutputStream(fous);
            zipFile(files, zipOut);
            zipOut.close();
            fous.close();
            return downloadZip(file, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 把接受的全部文件打成压缩包
     *
     * @param files
     * @param outputStream
     */
    public static void zipFile(List files, ZipOutputStream outputStream) {
        int size = files.size();
        for (int i = 0; i < size; i++) {
            File file = (File) files.get(i);
            zipFile(file, outputStream);
        }
    }

    /**
     * 根据输入的文件与输出流对文件进行打包
     *
     * @param inputFile
     * @param ouputStream
     */
    public static void zipFile(File inputFile, ZipOutputStream ouputStream) {
        try {
            if (inputFile.exists()) {
                if (inputFile.isFile()) {
                    FileInputStream IN = new FileInputStream(inputFile);
                    BufferedInputStream bins = new BufferedInputStream(IN, 512);
                    ZipEntry entry = new ZipEntry(inputFile.getName());
                    ouputStream.putNextEntry(entry);
                    // 向压缩文件中输出数据
                    int nNumber;
                    byte[] buffer = new byte[512];
                    while ((nNumber = bins.read(buffer)) != -1) {
                        ouputStream.write(buffer, 0, nNumber);
                    }
                    // 关闭创建的流对象
                    bins.close();
                    IN.close();
                } else {
                    try {
                        File[] files = inputFile.listFiles();
                        for (int i = 0; i < files.length; i++) {
                            zipFile(files[i], ouputStream);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


{"orderType":"例：RNA",

"orderId":"XXXXXXXXX",

"totalPrice":[{"ifKey":"1~2","totalPrice":"12"},{"ifKey":"2~3","totalPrice":"23"},{"ifKey":"3~4","totalPrice":"34"},{"ifKey":"4~5","totalPrice":"45"}]
,
"impactFactor":["1","5"],

"description":"XXXXXX","keyword":"例：Epigenetics; Polycomb complexes; central nervous system; neurological diseases; non-coding RNAs",

"deadline":"XXXX年XX月XX日",
"title":"XXXXXXXX"}
