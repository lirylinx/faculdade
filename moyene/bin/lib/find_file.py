import os.path
import glob


#definir o caminho por onde listar o conteudo
env_dir = 'static/img'
conteudo = "*"      # encontrar todo tipo de ficheiro no directorio currente
basedir = env_dir      # directorio onde se encontra o executavel

### Extensoes uteis para filtros nas buscas por um tipo de ficheiro ###
audio_ext = {'asf': 'asf', 'flac':'flac', 'm4a':'m4a','ogg':'ogg', 'mp3':'mp3', 'wav':'wav'}
image_ext = {'png':'png', 'jpg':'jpg', 'jpeg':'jpeg', 'gif': 'gif'}
video_ext = {'mp4':'mp4', 'flv':'flv'}

### lista de cada de tipo de ficheiro  encontrado em um deterinado directorio ###
audio_file_list = []
image_file_list = []
video_file_list = []
other_files = []

"""
TODO:
 - criar um dicionario para guardar informacoes uteis de cada ficheiro encontrado ou directorio
 - Tornar o findFile recursivo para buscar ficheiros em subpastas. e definir numero de profundidade ignorando links
     de outros directorios mas registrando no dicionario
"""


def findFile(path=basedir, filtro=conteudo):
    full_path = os.path.abspath(path=path) # retornar o caminho absoluto
    busca = os.path.join(full_path, conteudo)
    files = glob.glob(busca)
    for file in sorted(files):
        if (str(file).endswith(audio_ext['mp3']) == True):
              audio_file_list.append(file)
        elif (str(file).endswith(video_ext['mp4']) == True):
              video_file_list.append(file)

        elif (str(file).endswith(image_ext['jpg']) == True):
              image_file_list.append(file)

        elif (str(file).endswith(image_ext['png']) == True):
              image_file_list.append(file)

        else:
            other_files.append(file)

    files_dic = {'audio': audio_file_list, 'video': video_file_list, 'image': image_file_list, 'other': other_files}
    return files_dic

def list_file():
    files_dic = findFile()
    print("list files\n")
    for k in files_dic:
        print('\n')
        print(k)
        print("__________\n")

        for v in files_dic[k]:
            print(v)


def teste():
    list_file()

def main():
    teste()
if __name__ == '__main__':
    main()
