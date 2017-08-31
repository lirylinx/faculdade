import web
import os

import findFile
urls = ('/*', 'Index',)

app = web.application(urls, globals())
render = web.template.render('templates/', base="layout")

# Lista de directorio para ficheiros carregados
dirs = ["imagem", "audio", "video", "documento", "outros"]
extensao = {
    "imagem": ["jpg", "png", "gif"],
    "audio": ["mp3", "aac", "ogg", "wav"],
    "video": ["mp4", "flv", "mkv", "3gp"],
    "documento": ["pdf", "doc", "docx", "ppt", "pptx"]
}
list_file_dic = []



def saveUpload(fp):
    """
    Salvar o ficheiro carregado em um directorio.
    #TODO:  criar pasta para cada tipo de ficheiro
    :param fp:
    :return void:
    """
    filename= fp['ficheiro'].filename
    upload_to = 'moyene_file' # Directorio
    if not os.path.exists(upload_to):
        os.mkdir(upload_to)

    with  open(upload_to+ '/' + filename, 'wb') as file:
        file.write(fp['ficheiro'].value)



def listaFiles(key):
    """
    busca por ficheiros e organiza por tipo de ficheiro
    :param key: nome do tipo de ficheiro Ex: imagem, audio, video ...
    :return lista da key especificada:
    """
    lista = findFile.findFile()
    img_lista = lista[key]
    return img_lista







def listDir():
    """
        Listar ficheiro do directorio currente, verificar antes a sua autenticidade, permissoes e criar
        um dicionario com descricoes do ficheiro
    :return list: lista de ficheiro de directorios
    """

    lista = []
    dir = os.curdir
    lista_file = os.listdir(dir)
    if len(lista_file) == 0:
        return  []


    offset = 52
    file_dic = {
        'nome': '',
        'path': '',
        'regular_path': '',
        "ext": ""



    } # handle file information

    for li in lista_file:

        full_path = os.path.abspath(li)
        file_dic['nome'] = li
        file_dic['path'] = full_path[offset:]
        file_dic['regular_path'] = full_path
        if os.path.isdir(li):
            file_dic['type'] = "dir"
        elif os.path.isfile(li):
            file_dic['type'] = "file"

        """
        if os.path.isfile(full_path):
            file_dic['isfile'] = True
            ext = li.split(".")
            if len(ext) == 1:
                file_dic['ext'] = "bin"
            else:
                file_dic['ext'] = ext[-1]

        elif os.path.isdir(full_path):
            file_dic['isdir'] = True
            lista.append(file_dic)
            print file_dic
            continue


        elif os.path.islink(full_path):
            file_dic['islink'] = True
        """
        #lista += [file_dic['nome'], file_dic['ext'], file_dic['path'],file_dic['regular_path']
        #          , file_dic['isfile'], file_dic['isdir'], file_dic['islink']]

        lista += [{'nome':  file_dic['nome'],
                   "tipo": file_dic['type']
                   }]
    return lista






list_list_append= []

class Index(object):

    def GET(self):
        """
            Actuando modo GET. Quando solicitamos uma pagina ou algum ficheiro
        :return pagina renderizada e com variaveis de argumento passando para a pagina html:
        """
        img_lista = listaFiles("imagem")
        list_dir = listDir()
        msg = ""
        return render.index(greeting="hey", img_lista=img_lista, list_dir=list_dir,msg=msg)

    def POST(self):
        global list_list_append
        """
            Actuando em modo post. Quando recebemos dados vindo de algum formulario
        :return: pagina renderizada e com variaveis de argumento passando para a pagina html
        """
        msg = ""
        data = web.input(ficheiro={})

        
        if data['ficheiro'].filename != '':
            fp = data
            saveUpload(fp)
        
        img_lista = listaFiles("imagem")
        list_dir = listDir()
        greeting= "carregado" + msg  #"Carregado com Sucesso ou nao"

        return render.index(greeting = greeting, img_lista=img_lista, list_dir=list_dir, msg="")


if __name__ == "__main__":
    app.run()
