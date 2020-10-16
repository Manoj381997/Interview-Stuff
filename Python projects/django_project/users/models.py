from django.db import models
from django.contrib.auth.models import User
# from django.forms import ModelForm, Textarea
from PIL import Image

# Create your models here.
class Profile(models.Model):
    user = models.OneToOneField(User, on_delete=models.CASCADE) # CASCADE, means if user is deleted then delete's profile but not vice versa
    image = models.ImageField(default='default.jpg', upload_to='profile_pics')  # upload_to, is the directory where the pics get uploaded to.
    # bio = Textarea(attrs={'cols': 80, 'rows': 20})
    # current_city = 

    def __str__(self):
        return f'{self.user.username} Profile'

    def save(self): # overriding save mthd in order to resize large img's
        super().save()
        
        img = Image.open(self.image.path)

        if img.height > 300 or img.width > 300:
            output_size = (300, 300)
            img.thumbnail(output_size)
            img.save(self.image.path)