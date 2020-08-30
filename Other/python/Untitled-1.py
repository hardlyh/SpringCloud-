import requests
import json
import ast
from jqdatasdk import *
from PIL import Image
import pytesseract

global false, null, true
false = null = true = ''
# 登录模块
def login(user,pas):
    # 获取验证码
    url = "http://www.boseaudio.cn/api/verifyCode/get"
    headers = {
        "Host":"www.boseaudio.cn",
        "Connection":"keep-alive",
        "luckkey":"undefined",
        "User-Agent":"Mozilla/5.0 (Linux; Android 9; MI 6 Build/PKQ1.190118.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/80.0.3987.99 Mobile Safari/537.36 Html5Plus/1.0",
        "Accept":"*/*",
        "X-Requested-With":"plus.H58AB011E",
        "Accept-Encoding":"gzip, deflate",
        "Accept-Language":"zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7",
        "Cookie":"PHPSESSID=33cova95pldabfc35qnaaj8e950"
    }
    r = requests.post(url, headers=headers, verify=False)
    print(r.text)
    httpData = r.text.replace("\\r\\n","")
    print(httpData)
    validateData = eval(httpData)
    imgBase = validateData['data']['url']
    
def imgageBase():
    text=pytesseract.image_to_string(Image.open('C:\\Users\\liyuhui\\Desktop\\222.png'),lang='chi_sim')
    print(text)

# 获取所有人数
def getPeopleCount():
    return 1


# 获取自己的订单
def getSelfOrder():
    return 1

# 获取未支付的订单
def getNoPayOrder():
    return 1

# 自动购买
def pay():
    return 1

# sql连接
def sql():
    return 1

# 发送消息模块,暂时只有发送文字功能
def sendMsg(str):
    datas =  {
        "msgtype": "text",
        "text":
        {
        "content": "**"+str
        }
    }
    headers = {
        'Content-Type':'application/json',
    }
    url = "https://oapi.dingtalk.com/robot/send?access_token=8bbd1894881c838e2fe8a3f9381c13210c08b2d78c9463f0e6550b2a21f5d496"
    r = requests.post(url,data=json.dumps(datas), headers=headers, verify=False)
    print(r.text)



def JqData():
    loginToken = auth("17853487495","Aa380056867")
    isAuth = is_auth()

    # info = finance.run_query(query(finance.FUND_MAIN_INFO).filter(finance.FUND_MAIN_INFO.main_code=='161726').limit(10))
    # print(info)

    q=query(finance.FUND_NET_VALUE).filter(finance.FUND_NET_VALUE.code=="161726").order_by(finance.FUND_NET_VALUE.day.desc()).limit(10)
    df=finance.run_query(q)
    print(df)

    # df=finance.run_query(query(finance.FUND_MF_DAILY_PROFIT).filter(finance.FUND_MF_DAILY_PROFIT.code=='161726').order_by(finance.FUND_MF_DAILY_PROFIT.end_date.desc()).limit(100))
    # print(df)

if __name__ == '__main__':
    imgageBase()
