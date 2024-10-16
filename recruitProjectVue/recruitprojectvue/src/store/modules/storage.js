export const getInfo = () =>{
    const defaultObj = ''
    const result = localStorage.getItem("token");
    return result ? result : defaultObj
}
export const setInfo = (obj) =>{
    localStorage.setItem("token",obj)

}
export const removeInfo = () =>{
    localStorage.removeItem("token")

}