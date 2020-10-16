from django.db import models
from django.utils import timezone
from django.contrib.auth.models import User
from django.urls import reverse

# Create your models here.
class Post(models.Model):
    title = models.CharField(max_length=200)
    content = models.TextField()
    date_posted = models.DateTimeField(default=timezone.now)
    author = models.ForeignKey(User, on_delete=models.CASCADE)  # on_delete arg, is likely to delete the posts created by user when the user is no longer existing..

    def __str__(self):
        return self.title

    def get_absolute_url(self):     # Reversing the url, in post creation, which is redirecting to previous page as "String"
        return reverse('post-detail', kwargs={'pk': self.pk})