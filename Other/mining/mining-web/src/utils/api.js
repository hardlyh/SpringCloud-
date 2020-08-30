import request from '@/utils/request'


const apis = {
    getPayInfo(data) {
        return request({
            url: "/miningOutlay/getDateCountInfo",
            method: 'post',
            data: data
        })
    },
    getPayInfoDetail(data) {
        return request({
            url: "/miningOutlay/getDateDetailInfo",
            method: 'post',
            data: data
        })
    },
    getIncomeInfo(data) {
        return request({
            url: "/miningIncome/getInComeDateCountInfo",
            method: 'post',
            data: data
        })
    },
     getIncomeInfoDetail(data) {
        return request({
            url: "/miningIncome/getInComeDateDetailInfo",
            method: 'post',
            data: data
        })
    },
    savePayInfo(data){
        return request({
            url: "/miningOutlay/saveOutLayInfo",
            method: 'post',
            data: data
        })
    }
}

export default apis