import requests as req
import re

base_url ='http://i.youku.com'
def fetch(id=1, debug=False):
    urlbase = 'http://i.youku.com/u/UMTE0NDEzOTky/videos/'
    url = urlbase + 'order_1_view_1_page_' + str(id) + '/'
    res = req.get(url)
    return res.content.decode('utf-8')


def parse(html,debug):
    abstract = re.compile(r'<div class="v-link">.*?</div>', re.DOTALL).findall(html)
   # print(abstract)
    vid_list = []
    for i in range(0,len(abstract)):
    	href =re.compile(r'href="//(.*?)"',re.DOTALL).findall(abstract[i])
    	v_url=href[0]
    	#print(base_url+href[0])
    	vid_list.append(v_url)
    	'''
        title = re.compile(r'title="(.*?)"',re.DOTALL).findall(abstract[i])
        href = re.compile(r'href="(.*?)"',re.DOTALL).findall(abstract[i])
        date = re.compile(r'<span>(.*?)',re.DOTALL).findall(abstract[i])
        if debug == True:
            print (title[0]+href[0]+date[0])
            vid = { 'title' : title[0], 'href' : href[0],  'date' : date[0]}
            vid_list.append(vid)
            '''
    return vid_list


if __name__ == '__main__':
    html = fetch()
    #print(html)
    vlist=parse(html,True)
    print(vlist)
