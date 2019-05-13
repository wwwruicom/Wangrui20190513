package com.bawei.wangrui20190513;

import java.util.List;

public class MyBean {
    List<Items> items;

    public MyBean(List<Items> items) {
        this.items = items;
    }
    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public class Items{
        String title;
        String desc;
        String image;
        List<Images> images;

        public Items(String title, String desc, String image, List<Images> images) {
            this.title = title;
            this.desc = desc;
            this.image = image;
            this.images = images;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public List<Images> getImages() {
            return images;
        }

        public void setImages(List<Images> images) {
            this.images = images;
        }

        class Images{
            String pic;

            public Images(String pic) {
                this.pic = pic;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }
        }
    }
}
